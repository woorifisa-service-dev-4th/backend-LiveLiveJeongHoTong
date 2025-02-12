package model;

import static util.RandomNicknameGenerator.*;

public class Guest extends Person {
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

}
