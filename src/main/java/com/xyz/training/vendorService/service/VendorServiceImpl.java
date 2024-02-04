package com.xyz.training.vendorService.service;

import com.xyz.training.vendorService.model.Vendor;
import com.xyz.training.vendorService.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl  implements VendorService {

    private final VendorRepository vendorRepository;


    @Override
    @Cacheable(value = "vendors")
    public List<Vendor> getalldetails() {
        return vendorRepository.findAll();
    }

    @Override
   @CachePut(value="vendors")
    public void createVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public void updateVendor(int id, Vendor vendor) {
        vendorRepository.saveAndFlush(vendor);
    }

    @Override
    public void partialVendor(int id, Vendor vendor) {
        vendorRepository.saveAndFlush(vendor);
    }

    @Override
    //@CacheEvict(value="vendor")
    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }


}