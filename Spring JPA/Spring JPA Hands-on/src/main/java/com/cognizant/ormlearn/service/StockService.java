package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repository;
	
//	public List<Stock> getAllStock(String code, int month, int year){
//		return repository.findStockByCodeAndMonthAndYear(code, month, year);
//	}
	public List<Stock> getAllStockPriceGT(){
		return repository.findStockPriceGT();
	}
}