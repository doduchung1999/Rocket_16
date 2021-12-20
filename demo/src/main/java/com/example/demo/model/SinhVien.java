package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "sinhvien")
public class SinhVien {
    @Id
    private ObjectId id;

    @Field(value = "ten")
    private String ten;

    @Field(value = "tuoi")
    private int tuoi;

    @Field(value = "dia chi")
    private String diaChi;

    @Field(value = "CLB")
    private String[] CLB;

    @Field(value = "diem")
    private Diem[] diem;
}
