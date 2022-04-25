package com.abhishek.batchprocessing.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NiftyStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate tradingDate;
	
	private String symbol;
	
	private String securityType;
	
	private double prevClose;
	
	private double open;
	
	private double high;
	
	private double low;
	
	private double lastPrice;
	
	private double close;
	
	// volume weighted average price
	private double vwap;
	
	private long volume;
	
	private String turnover;
	
	private String tradesTotal;
	
	private String deliverableVolume;
	
	private String deliverablePercent;
	
	private LocalDateTime timeStamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(LocalDate tradingDate) {
		this.tradingDate = tradingDate;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public double getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(double prevClose) {
		this.prevClose = prevClose;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVwap() {
		return vwap;
	}

	public void setVwap(double vwap) {
		this.vwap = vwap;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getTradesTotal() {
		return tradesTotal;
	}

	public void setTradesTotal(String tradesTotal) {
		this.tradesTotal = tradesTotal;
	}

	public String getDeliverableVolume() {
		return deliverableVolume;
	}

	public void setDeliverableVolume(String deliverableVolume) {
		this.deliverableVolume = deliverableVolume;
	}

	public String getDeliverablePercent() {
		return deliverablePercent;
	}

	public void setDeliverablePercent(String deliverablePercent) {
		this.deliverablePercent = deliverablePercent;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
