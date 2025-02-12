package executor;

import static util.Reader.*;

import model.ChatRoom;
import model.Guest;
import model.Person;
import service.ChatRoomService;
import service.GuestChatService;

import java.util.Scanner;

public class Executor {
	private static final ChatRoomService chatRoomService = new ChatRoomService();
	private static final GuestChatService service = new GuestChatService();
	// 제가 또 궁금했던게
	// 여기서 만약에 2를 하면 채팅방 번호 입력해서
	// enter chat이잖아요 근데 그러면 어디서 number을 애초에 매개변수로
	// 받는거지? 싶어서

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
				chatRoomService.createChatRoom(roomName);
				System.out.println("채팅방 생성됨: " + chatRoom);

				enterChat(p);
				break;
			case 2:
				int number = roomNumberReader();
				service.enter(number);
				break;
		}
	}
	public static void getChatRoomList() {
		System.out.println("채팅방 목록");
		System.out.println(chatRoomService.getChatRooms().size());
		chatRoomService.getChatRooms().forEach((key, value) -> System.out.println(key + ". " + value));
	}
	public static void enterChat(Person p){
		System.out.println("1. 채팅방 목록 보기 2. 메인으로 돌아가기");
		// 동작을 선택하세요.
		//1. 채팅방 목록 보기 2. 메인으로 돌아가기  L1로 이  동
		int option = optionsReader("번호를 입력하세요: "); // 입력값을 정수로 변환
		GuestChatService service = new GuestChatService();
		switch (option) {
			case 1:
				getChatRoomList();
				int number = roomNumberReader();
				service.enter(number);
				break;
			case 2:
				startChat(p);
				break;
		}
	}
}
