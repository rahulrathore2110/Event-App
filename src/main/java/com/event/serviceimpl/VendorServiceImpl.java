package com.event.serviceimpl;

import com.event.exception.VendorException;
import com.event.model.Vendor;
import com.event.repository.VendorDao;
import com.event.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public Vendor addVendor(Vendor vendor) {
        return this.vendorDao.save(vendor);
    }


    @Override
    public Vendor updateVendor(Vendor vendor) throws VendorException {
        Vendor vendorUpdate =
                this.vendorDao.findById(vendor.getUid()).orElseThrow(()->new VendorException(
                "No vendor found with this id : "+vendor.getUid()));


        return this.vendorDao.save(vendor);
    }

    @Override
    public String deleteVendor(Integer eventId) throws VendorException {
        Vendor vendor = this.vendorDao.findById(eventId).orElseThrow(()->new VendorException("No event found with thid id : "+eventId));
        this.vendorDao.delete(vendor);
        return "vendor delete successfully with id : "+ vendor.getUid();
    }

    @Override
    public List<Vendor> getVendorByPages(Integer pageSize, Integer pageNo) {


        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        Page<Vendor> vendorPage = this.vendorDao.findAll(pageable);
        List<Vendor> vendors = vendorPage.getContent();


        return vendors;
    }
}
