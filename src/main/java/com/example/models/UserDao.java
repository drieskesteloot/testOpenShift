package com.example.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by u0109585 on 4/12/2016.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long>{

    public User findByEmail(String email);

}
