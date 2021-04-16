package com.mb.githubusersinfo.user;

public class CalculatedUserInfo
{
    int id;
    String login;
    String name;
    String type;
    String avatarUrl;
    String createdAt;
    float calculations;

    public CalculatedUserInfo(int id, String login, String name, String type, String avatarUrl, String createdAt, float calculations)
    {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculations;
    }

    @Override
    public String toString()
    {
        return "UserInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", calculations=" + calculations +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public float getCalculations()
    {
        return calculations;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setCalculations(int calculations)
    {
        this.calculations = calculations;
    }
}
