package com.example.testmongodbtemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("congdan")
public class CongDan {
    @Id
    private String id;
    private String Ho_ten;
    private String sdt;
    private Diachi diachi;
    private String ngaysinh;

}
