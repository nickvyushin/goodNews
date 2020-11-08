package com.aggregator.goodNews.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "password")
public class RegForm {

    private String fullName;
    private Integer age;
    private String login;
    private String password;

}
