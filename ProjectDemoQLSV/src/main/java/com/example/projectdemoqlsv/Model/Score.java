package com.example.projectdemoqlsv.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@Document(value = "score")
public class Score {
    @Field(value = "cc")
    private float diemCC;
    @Field(value = "kt")
    private float diemKT;
}
