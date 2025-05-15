package com.baitap.session09.modal;
public class Seat {
    private Long id;
    private Long screenRoomId;
    private String seatNumber;
    private Double price = 50000.0;
    private String status; // available, booked

    public Seat() {}

    public Seat(Long id, Long screenRoomId, String seatNumber, Double price, String status) {
        this.id = id;
        this.screenRoomId = screenRoomId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(Long screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

