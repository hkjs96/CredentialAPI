package com.futuresense.credentialrestapi.persistence;

import com.futuresense.credentialrestapi.model.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, String> {
    Boolean existsByHash(String hash);

    InfoEntity findByIdAndHash(String id, String Hash);
}
