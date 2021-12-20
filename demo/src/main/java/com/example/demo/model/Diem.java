package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "diem")
@Setter
@Getter
@NoArgsConstructor
public class Diem {
    @Field(value = "van")
    private float diemVan;

    @Field(value = "toan")
    private float diemToan;

    @Field(value = "anh")
    private float diemAnh;
}
