package com.abhishek.batchprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.batchprocessing.entity.NiftyStock;

@Repository
public interface NiftyStockRepository extends JpaRepository<NiftyStock, Long>{

}
