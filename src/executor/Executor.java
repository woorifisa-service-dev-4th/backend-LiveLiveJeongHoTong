package executor;

import static util.Reader.*;

import model.ChatRoom;
import model.Guest;
import model.Host;
import model.Person;

public class Executor {

	public static void startChat(Person p) {
		  System.out.println("1. 채팅방 생성하기 (강사만 가능)  2. 채팅방 입장하기");
		int option = optionsReader("번호를 입력하세요: "); // 입력값을 정수로 변환
		ChatRoom chatRoom;

		switch (option) {
			case 1:
				if (p == null || p instanceof Guest) {
					System.out.println("권한이 없습니다.\n ");
					startChat(p);
					return;
				}
				String roomName = roomNameReader();
				chatRoom = new ChatRoom(roomName);
				System.out.println("채팅방 생성됨: " + chatRoom);
				break;
			default:
				// System.out.println("🚧 채팅방 입장 기능은 준비 중입니다.");
				break;
		}
	}

	public static void main(String[] args) {
		startChat(new Guest(111));
	}
}
