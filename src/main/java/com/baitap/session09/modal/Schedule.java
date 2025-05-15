
package com.baitap.session09.modal;

import java.util.Date;

public class Schedule {
    private Long id;
    private String movieTitle;
    private Date showTime;
    private Long screenRoomId;
    private Integer availableSeats;
    private String format;  // Ví dụ: "2D" hoặc "3D"

    // Constructor mặc định
    public Schedule() {
    }

    // Constructor đầy đủ
    public Schedule(Long id, String movieTitle, Date showTime, Long screenRoomId, Integer availableSeats, String format) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.screenRoomId = screenRoomId;
        this.availableSeats = availableSeats;
        this.format = format;
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Long getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(Long screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    private String screenRoomName;

    public String getScreenRoomName() {
        return screenRoomName;
    }

    public void setScreenRoomName(String screenRoomName) {
        this.screenRoomName = screenRoomName;
    }

}
