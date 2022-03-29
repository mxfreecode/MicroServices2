package com.booking.app.dto;

public class BookingDTO {

	
	private Integer bookId;
	private Integer userId;
	private Integer trainId;
	private String username;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getTicketsQuantity() {
		return ticketsQuantity;
	}
	public void setTicketsQuantity(Integer ticketsQuantity) {
		this.ticketsQuantity = ticketsQuantity;
	}
	private Integer ticketsQuantity;
}
