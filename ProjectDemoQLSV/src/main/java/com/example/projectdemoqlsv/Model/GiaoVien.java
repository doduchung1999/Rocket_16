package com.example.projectdemoqlsv.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "QLSV")
public class GiaoVien {
    @Id
    private Id _id;
    @Field(value = "code")
    private String code;
    @Field(value = "ten")
    private String ten;
    @Field(value = "position")
    private String position;
    @Field(value = "email")
    private String email;
    @Field(value = "password")
    private String password;
}
