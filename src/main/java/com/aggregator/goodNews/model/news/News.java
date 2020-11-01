package com.aggregator.goodNews.model.news;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class News {

    private String url;
    private String title;
    private Long publishedAt;
    private String imageUrl;
}
