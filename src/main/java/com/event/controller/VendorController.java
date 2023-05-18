package com.event.controller;

import com.event.exception.VendorException;
import com.event.model.Vendor;
import com.event.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v3/app")
public class VendorController {

    @Autowired
    private VendorService eventService;


    @PostMapping("/vendor")
    public ResponseEntity<Vendor> addEventHandler(@RequestBody Vendor vendor) {
        Vendor addVendor = this.eventService.addVendor(vendor);
        return new ResponseEntity<Vendor>(addVendor, HttpStatus.CREATED);
    }

    @PutMapping("/vendor")
    public ResponseEntity<Vendor> updateEventHandler(@RequestBody Vendor vendor) throws VendorException {
        Vendor addVendor = this.eventService.updateVendor(vendor);
        return new ResponseEntity<Vendor>(addVendor, HttpStatus.CREATED);
    }

    @DeleteMapping("/vendor/{vendorId}")
    public ResponseEntity<String> deleteEventHandler( @PathVariable Integer vendorId) throws VendorException {
        String deleteVendor = this.eventService.deleteVendor(vendorId);
        return new ResponseEntity<String>(deleteVendor, HttpStatus.CREATED);
    }

    @GetMapping("/vendor")
    public ResponseEntity<List<Vendor> > getEventByPageNoHandler(@RequestParam(value = "pageSize"
            ,defaultValue = "5", required = false) Integer PageSize,
                                                                 @RequestParam(value = "pageNo",defaultValue = "1", required = false) Integer pageNo) throws VendorException {
        List<Vendor> vendorByPages = this.eventService.getVendorByPages(PageSize, pageNo);
        return new ResponseEntity<List<Vendor> >(vendorByPages, HttpStatus.CREATED);
    }





}
