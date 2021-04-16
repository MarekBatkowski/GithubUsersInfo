package com.mb.GithubUsersInfo.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestsCount
{
    @Id
    private String login;
    private Integer request_count;

    public String getLogin()
    {
        return login;
    }

    public Integer getRequest_count()
    {
        return request_count;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setRequest_count(Integer request_count)
    {
        this.request_count = request_count;
    }
}
