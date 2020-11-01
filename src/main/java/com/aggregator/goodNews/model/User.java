package com.aggregator.goodNews.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class User {

    private String login;
    private String password;
    private Integer age;

}
