package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
	@Query("select s from Stock s where s.stockCode=?1 and month(s.stockDate)=?2 and year(s.stockDate)=?3")
	public List<Stock> findStockByCodeAndMonthAndYear(String code, int month, int year);
	
	@Query("select s from Stock s where s.stockCode='Googl' and s.closingStock>1250")
	public List<Stock> findStockPriceGT();
	
	@Query(value = "select * from Stock  order by st_volume desc LIMIT 3",nativeQuery = true)
	public List<Stock> top3Volume();
	
//	@Query(value = "SELECT * FROM Stock where st_code='NFLX' order by st_close LIMIT 3",nativeQuery = true)
//	public List<Stock> least3Stocks();
	
	@Query("select s from Stock s where s.stockCode=?1")
	public List<Stock> findByStockCodeAndVolume(String stockCode,Sort sort);
	
	public List<Stock> findByOrderByVolumeDesc();
	@Query("select s from Stock s")
	public List<Stock> findThreeHighestVolumeStock(Pageable pageable);
}