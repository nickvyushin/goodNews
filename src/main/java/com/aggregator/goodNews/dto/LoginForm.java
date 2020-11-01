package com.aggregator.goodNews.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoginForm {

    private String login;
    private String password;
}
