package com.example.testmongodbtemplate.controller;

import com.example.testmongodbtemplate.model.CongDan;
import com.example.testmongodbtemplate.repository.CongDanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/congdan")
@CrossOrigin("*")
public class CongDanController {

    @Autowired
    CongDanRepository congDanRepository;

    @PostMapping("")
    public ResponseEntity<?> insertCongdan(@RequestBody CongDan congDan){
        CongDan congDan1 = new CongDan();
        congDan1.setNgaysinh(congDan.getNgaysinh());
        congDan1.setDiachi(congDan.getDiachi());
        congDan1.setId(congDan.getId());
        return ResponseEntity.ok().body(congDanRepository.save(congDan1));
    }
}
