package com.futuresense.credentialrestapi.controller;

import com.futuresense.credentialrestapi.dto.ResponseDTO;
import com.futuresense.credentialrestapi.model.InfoEntity;
import com.futuresense.credentialrestapi.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping("/issue")
    public ResponseEntity<?> storeCredential(@RequestBody InfoEntity infoEntity) {
        try {
            InfoEntity storedInfo = infoService.create(infoEntity);
            return ResponseEntity.ok().body(infoEntity);
        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCredential(@RequestBody InfoEntity infoEntity) {
        String status = infoService.verify(infoEntity);
        return ResponseEntity.ok().body(status);
    }
}
