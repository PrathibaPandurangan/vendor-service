package com.xyz.training.vendorService.controller;

import com.xyz.training.vendorService.model.Vendor;
import com.xyz.training.vendorService.repository.VendorRepository;
import com.xyz.training.vendorService.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/vendorservice")
@RequiredArgsConstructor
public class VendorController {
    @Autowired
    private VendorRepository vendorrepository;
    private final VendorService vendorservice;


    @GetMapping(value = "/list")
    public List<Vendor> getalldetails() {

        return vendorservice.getalldetails();

    }

    @PostMapping

    public ResponseEntity<String> createVendor(@RequestBody Vendor vendor) {
        vendorservice.createVendor(vendor);
        return ResponseEntity.ok("vendor created");
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateVendor(@PathVariable int id, @RequestBody Vendor vendor)
    {
        Vendor existingvendor = vendorrepository.findById(id).orElse(null);
        if (existingvendor != null)
        {
            existingvendor.setName(vendor.getName());
            existingvendor.setAddress(vendor.getAddress());
            vendorrepository.save(existingvendor);
            return new ResponseEntity<>("vendor updated successfully", HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>("vendor not updated", HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping(value = "/partial/{id}")
    public ResponseEntity<Void> partialVendor(@PathVariable int id, @RequestBody Vendor vendor) {
        vendor.setId(vendor.getId());
        vendor.setName(vendor.getName());
        vendorservice.partialVendor(id, vendor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable int id) {
        vendorservice.deleteVendor(id);
        return ResponseEntity.ok().build();
    }

}

