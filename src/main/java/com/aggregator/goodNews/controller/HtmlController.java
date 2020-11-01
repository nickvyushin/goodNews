package com.aggregator.goodNews.controller;

import com.aggregator.goodNews.model.news.MeduzaNews;
import com.aggregator.goodNews.model.news.News;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

@Controller
public class HtmlController {

    @GetMapping("/news-page")
    public String newsPage(Model model) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .GET()
                .uri(new URI("https://meduza.io/api/v3/search?chrono=news&locale=ru&page=0&per_page=100"))
                // .header("User-Agent", "Mozilla Firefox 5.0")
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        String result;

        try (var gzip = new GZIPInputStream(new ByteArrayInputStream(response.body()));
             var reader = new InputStreamReader(gzip);
             var in = new BufferedReader(reader);
        ) {
            // Так как при работе со строками операция + (конкатенации) создает новую строку (нерационально)
            // Рекомендуется работать с классами StringBuilder/StringBuffer (на собеседованиях про них спрашивают)
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }

            result = builder.toString();
        }

        var objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        var meduzaNews = objectMapper.readValue(result, MeduzaNews.class);

        var news = new ArrayList<News>();


        for (var entry : meduzaNews.getDocuments().entrySet()) {
            System.out.println(entry.getValue().getShareImageUrl());
            news.add(new News(entry.getValue().getUrl(), entry.getValue().getTitle(), entry.getValue().getPublishedAt(), entry.getValue().getShareImageUrl()));
        }

        model.addAttribute("news", news);
        return "news";
    }

}
