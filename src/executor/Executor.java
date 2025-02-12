package executor;

import static util.Reader.*;

import model.ChatRoom;

public class Executor {
	public static void startChat() {
		System.out.println("1. 채팅방 생성하기  2. 채팅방 입장하기");

		int option = optionsReader(); // 입력값을 정수로 변환
		ChatRoom chatRoom;
		switch (option) {
			case 1:
				String roomName = roomNameReader();
				chatRoom = new ChatRoom(roomName);
				System.out.println("채팅방 생성됨: " + chatRoom);
				break;
			case 2:
				System.out.println("🚧 채팅방 입장 기능은 준비 중입니다.");
				break;
		}
	}

}
