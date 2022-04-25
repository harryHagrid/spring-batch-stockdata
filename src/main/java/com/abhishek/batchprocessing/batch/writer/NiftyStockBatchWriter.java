package com.abhishek.batchprocessing.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhishek.batchprocessing.entity.NiftyStock;
import com.abhishek.batchprocessing.repository.NiftyStockRepository;

@Component
public class NiftyStockBatchWriter implements ItemWriter<NiftyStock> {

	@Autowired
	private NiftyStockRepository niftyRepo;
	
	@Override
	public void write(List<? extends NiftyStock> items) throws Exception {
		
		this.niftyRepo.saveAll(items);
	}
	
	

}
