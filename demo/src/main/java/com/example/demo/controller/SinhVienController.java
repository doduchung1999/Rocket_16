package com.example.demo.controller;

import com.example.demo.Repository.SinhVienRepository;
import com.example.demo.model.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sinhvien")
@CrossOrigin("*")
public class SinhVienController{
    @Autowired
    SinhVienRepository sinhVienRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SinhVien> getAll(){
        return sinhVienRepository.findAll();
    }
}
