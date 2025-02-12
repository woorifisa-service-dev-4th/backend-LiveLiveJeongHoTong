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

}
