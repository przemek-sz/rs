package com.szczerbap.rssreader.repository;

import com.szczerbap.rssreader.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User getByUserName(String username);
}
