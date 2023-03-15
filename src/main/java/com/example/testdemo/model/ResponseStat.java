package com.example.testdemo.model;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JacksonXmlRootElement(localName = "ResponseStatus")
@NoArgsConstructor
@Getter
@Setter

public class ResponseStat {
	@JacksonXmlProperty(localName = "Status", isAttribute = true)
	private int status;
	@JacksonXmlProperty(localName = "ts", isAttribute = true)
	private Date timeStamp;
	@JacksonXmlProperty(localName = "txn", isAttribute = true)
	private Long transactionId;
	@JacksonXmlText
	private int resStat;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public int getResStat() {
		return resStat;
	}
	public void setResStat(int resStat) {
		this.resStat = resStat;
	}
}