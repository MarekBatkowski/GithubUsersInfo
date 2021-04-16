package com.mb.GithubUsersInfo;

public class GithubUserInfo
{
    int id;
    String login;
    String name;
    String type;
    String avatar_url;
    String created_at;
    int followers;
    int public_repos;

    public ServiceUserInfo getUserInfo()
    {
        float calculations = (float) 6.0 / followers * (2 + public_repos);
        try
        {
            if(followers == 0) throw new ArithmeticException("Divided by 0");
        }
        catch (ArithmeticException ae) // divided by 0;
        {
            calculations = -1;
        }
        return new ServiceUserInfo(id, login, name, type, avatar_url, created_at, calculations);
    }

    @Override
    public String toString()
    {
        return "GithubUserInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", followers=" + followers +
                ", public_repos=" + public_repos +
                '}';
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

    public void setAvatar_url(String avatar_url)
    {
        this.avatar_url = avatar_url;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public void setFollowers(int followers)
    {
        this.followers = followers;
    }

    public void setPublic_repos(int public_repos)
    {
        this.public_repos = public_repos;
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

    public String getAvatar_url()
    {
        return avatar_url;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public int getFollowers()
    {
        return followers;
    }

    public int getPublic_repos()
    {
        return public_repos;
    }
}
