package com.mongo.mongodemo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.mongodemo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
