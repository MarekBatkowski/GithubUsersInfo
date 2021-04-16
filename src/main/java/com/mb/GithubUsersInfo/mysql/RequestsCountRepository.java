package com.mb.GithubUsersInfo.mysql;

import org.springframework.data.repository.CrudRepository;

public interface RequestsCountRepository extends CrudRepository<RequestsCount, Integer>
{
    boolean existsByLogin(String login);
    RequestsCount getRequestsCountByLogin(String login);
}
