package com.futuresense.credentialrestapi.service;

import com.futuresense.credentialrestapi.model.InfoEntity;
import com.futuresense.credentialrestapi.persistence.InfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoEntity create(final InfoEntity infoEntity) {
        if(infoEntity == null || infoEntity.getId() == null || infoEntity.getHash() == null){
            throw new RuntimeException("Invalid arguments");
        }

        final String id = infoEntity.getId();
        /*if(infoRepository.existsById(id)) {
            log.warn("id already exists {}", id);
            infoRepository.save(infoEntity);
            throw new RuntimeException("id already exists and update hash");
        }*/

        return infoRepository.save(infoEntity);
    }

    public String verify(final InfoEntity infoEntity) {
        final InfoEntity originalInfo =
                infoRepository.findByIdAndHash(infoEntity.getId()
                        , infoEntity.getHash());

        if(originalInfo != null &&
        infoEntity.getId().equals(originalInfo.getId())  &&
        infoEntity.getHash().equals(originalInfo.getHash()) ) {
            return "success";
        }

        return "fail";
    }
}
