package com.example.testdemo.model;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor

@JsonRootName("PullURIRequest")
@JacksonXmlRootElement(localName = "PullURIRequest")
public class PullURIRequest {

	@Override
	public String toString() {
		return "PullURIRequest [x=" + x + ", version=" + version + ", timestamp=" + timestamp + ", transactionId="
				+ transactionId + ", orgId=" + orgId + ", format=" + format + ", docDetails=" + docDetails + "]";
	}


	@JacksonXmlProperty(isAttribute = true, namespace = "ns2")
	public final String x = "hello";
	
	@JacksonXmlProperty(isAttribute = true, localName = "ver")
    private String version;

    @JacksonXmlProperty(isAttribute = true, localName = "ts")
    private Date timestamp;

    @JacksonXmlProperty(isAttribute = true, localName = "txn")
    private String transactionId;

    public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getOrgId() {
		return orgId;
	}


	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public DocDetails getDocDetails() {
		return docDetails;
	}


	public void setDocDetails(DocDetails docDetails) {
		this.docDetails = docDetails;
	}


	@JacksonXmlProperty(isAttribute = true, localName = "orgId")
    private String orgId;

    @JacksonXmlProperty(isAttribute = true, localName = "format")
    private String format;

    
    private DocDetails docDetails;

    // constructors, getters and setters
}


