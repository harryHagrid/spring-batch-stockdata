package com.abhishek.batchprocessing.batch.processor;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.abhishek.batchprocessing.entity.NiftyStock;

@Component
public class NiftyStockBatchProcessor implements ItemProcessor<NiftyStock, NiftyStock> {

	@Override
	public NiftyStock process(NiftyStock item) throws Exception {
		
		
		
		item.setTimeStamp(LocalDateTime.now());
		
		return item;
	}

}
