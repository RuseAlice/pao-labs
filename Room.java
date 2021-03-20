package com.company;

public class Room {
    private int roomNumber;
    private String type;
    private int floor;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Room() {
        this.roomNumber = 0;
        this.type = "no type";
        this.floor = 0;
    }

    public Room(int roomNumber, String type, int floor) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.floor = floor;
    }
}
