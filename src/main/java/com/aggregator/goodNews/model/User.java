package com.aggregator.goodNews.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class User {

    private String fullName;
    private Integer age;
    private String login;
    private String password;

}
