package com.example.demorabbitmq.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("supplierId")
    private String supplierId;
    @JsonProperty("supplierName")
    private String supplierName;
    @JsonProperty("supplierUrl")
    private String supplierUrl;

}
