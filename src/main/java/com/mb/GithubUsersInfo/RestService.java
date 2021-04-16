package com.mb.GithubUsersInfo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService
{
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder)
    {
        restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON(String login)
    {
        String url = "https://api.github.com/users/"+login;
        return restTemplate.getForObject(url, String.class);
    }
}
