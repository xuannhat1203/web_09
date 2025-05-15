
package com.baitap.session09.modal;

public class ScreenRoom {
    private Long id;
    private String screenRoomName;
    private Integer totalSeat;

    // Constructor mặc định
    public ScreenRoom() {
    }

    // Constructor đầy đủ
    public ScreenRoom(Long id, String screenRoomName, Integer totalSeat) {
        this.id = id;
        this.screenRoomName = screenRoomName;
        this.totalSeat = totalSeat;
    }

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenRoomName() {
        return screenRoomName;
    }

    public void setScreenRoomName(String screenRoomName) {
        this.screenRoomName = screenRoomName;
    }

    public Integer getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }
}
