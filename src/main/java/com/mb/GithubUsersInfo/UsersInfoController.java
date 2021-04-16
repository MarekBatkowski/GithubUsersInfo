package com.mb.GithubUsersInfo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mb.GithubUsersInfo.mysql.RequestsCount;
import com.mb.GithubUsersInfo.mysql.RequestsCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class UsersInfoController
{
	@Autowired
	private RequestsCountRepository requestsCountRepository;

	private final RestService restService = new RestService(new RestTemplateBuilder());
	private final ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args)
	{
		SpringApplication.run(UsersInfoController.class, args);
	}

	@GetMapping("/users/{login}")
	public ServiceUserInfo userInfo(@PathVariable String login) throws IOException
	{
		// increase count in db
		if(requestsCountRepository.existsByLogin(login))
		{
			RequestsCount requestsCount = requestsCountRepository.getRequestsCountByLogin(login);
			requestsCount.setRequest_count(requestsCount.getRequest_count()+1);
			requestsCountRepository.save(requestsCount);
		}
		else
		{
			RequestsCount requestsCount = new RequestsCount();
			requestsCount.setLogin(login);
			requestsCount.setRequest_count(1);
			requestsCountRepository.save(requestsCount);
		}

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

		String userInfoString = restService.getPostsPlainJSON(login);
		GithubUserInfo githubUserInfo = objectMapper.readValue(userInfoString, GithubUserInfo.class);
		//System.out.println(githubUserInfo);

		ServiceUserInfo userInfo = githubUserInfo.getUserInfo();
		//System.out.println(userInfo);
		return userInfo;
	}
}
