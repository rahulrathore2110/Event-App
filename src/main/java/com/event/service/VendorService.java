package com.event.service;

import com.event.exception.VendorException;
import com.event.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {

    public Vendor addVendor(Vendor vendor);

    public Vendor updateVendor(Vendor vendor) throws VendorException;

    public String deleteVendor(Integer venderId) throws VendorException;

    public List<Vendor> getVendorByPages(Integer pageSize, Integer pageNo);



}
