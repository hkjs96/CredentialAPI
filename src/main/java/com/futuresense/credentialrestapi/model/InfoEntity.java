package com.futuresense.credentialrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfoEntity {
    @Id
    private String id; // SPIN portal User Id

    @Column(nullable = false, length = 512)
    private String hash; // VC hash value
}
