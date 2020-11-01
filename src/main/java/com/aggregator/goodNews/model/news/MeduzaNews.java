package com.aggregator.goodNews.model.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MeduzaNews {

    @JsonProperty("has_next")
    private Boolean hasNext;

    private Map<String, MeduzaNewsInfo> documents;

    private List<String> collection;

    @JsonProperty("_count")
    private Integer count;
}
