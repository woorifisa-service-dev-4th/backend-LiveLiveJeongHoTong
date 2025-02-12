package model;


import java.util.Date;

import static util.ChatRoomUtil.createChatRoomNumber;

public class ChatRoom {
    private String roomName;
    private int roomNumber;
    private Date createdDate;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        roomNumber = createChatRoomNumber();
        createdDate = new Date();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return String.format("방 이름: %s \n방 번호: %d \n방 생성 일자: %tF %tT\n", roomName, roomNumber, createdDate, createdDate);
    }
}
