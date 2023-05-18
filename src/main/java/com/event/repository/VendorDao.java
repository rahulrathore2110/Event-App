package com.event.repository;

import com.event.model.Vendor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorDao extends JpaRepository<Vendor,Integer> {

}
