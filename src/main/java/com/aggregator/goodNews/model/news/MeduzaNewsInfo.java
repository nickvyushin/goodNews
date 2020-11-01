package com.aggregator.goodNews.model.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MeduzaNewsInfo {

    private String url;
    private String title;

    @JsonProperty("published_at")
    private Long publishedAt;

    @JsonProperty("share_image_url")
    private String shareImageUrl;
}
