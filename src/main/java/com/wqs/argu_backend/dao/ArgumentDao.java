package com.wqs.argu_backend.dao;

import com.wqs.argu_backend.bean.Argument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

public interface ArgumentDao extends MongoRepository<Argument, String> {
}
