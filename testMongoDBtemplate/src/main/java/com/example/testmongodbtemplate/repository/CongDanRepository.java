package com.example.testmongodbtemplate.repository;

import com.example.testmongodbtemplate.model.CongDan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CongDanRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public CongDan save(CongDan congDan) {
        return mongoTemplate.save(congDan);
    }
}
