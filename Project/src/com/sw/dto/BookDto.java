package com.sw.dto;

public class BookDto {
	
	// field
	
	public String bId;
	public String bName;
	public String bAuthor;
	public String bPublisher;
	public String bClient;
	public String bExplain;
	
	// Constructor
	
	public BookDto() {
		
	}
	
	public BookDto(String bId, String bName, String bAuthor, String bPublisher) {
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
	}
	
	public BookDto(String bId, String bName, String bAuthor, String bPublisher, String bClient) {
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bClient = bClient;
	}
	
	public BookDto(String bId, String bName, String bAuthor, String bPublisher, String bClient, String bExplain) {
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bClient = bClient;
		this.bExplain = bExplain;
	}
	
	// getters and setters
	
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbPublisher() {
		return bPublisher;
	}
	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}
	public String getbClient() {
		return bClient;
	}
	public void setbClient(String bClient) {
		this.bClient = bClient;
	}
	public String getbExplain() {
		return bExplain;
	}
	public void setbExplain(String bExplain) {
		this.bExplain = bExplain;
	}
	
}