package com.xyz.training.vendorService.service;

import com.xyz.training.vendorService.model.Vendor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface VendorService {
     List<Vendor> getalldetails();

    void createVendor(Vendor vendor);

   void updateVendor(int id, Vendor vendor);

   void partialVendor(int id, Vendor vendor);
    void deleteVendor(int id);
}
