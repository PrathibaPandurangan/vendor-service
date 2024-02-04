package com.xyz.training.vendorService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name="vendor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Vendor implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="vendor_name")
    private String name;
    @Column(name="vendor_add")
    private String address;
}