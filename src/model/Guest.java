package model;

import static util.RandomNicknameGenerator.*;

public class Guest {
	private String nickname;
	private int roomNumber;

	public Guest( int roomNumber) {
		this.nickname = generateNickname();
		this.roomNumber = roomNumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public void enterRoom(){
		//임시 언언
	}
}
