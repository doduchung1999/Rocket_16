package com.example.demo.Repository;

import com.example.demo.model.SinhVien;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends MongoRepository<SinhVien, ObjectId> {
//    SinhVien findBy_Id(ObjectId id);
//    @Autowired
//    MongoTemplate mongoTemplate;
}
