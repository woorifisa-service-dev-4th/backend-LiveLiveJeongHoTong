package repository;

import java.util.HashMap;
import java.util.Map;

import model.ChatRoom;

public class ChatRoomRepository {
	private final Map<Integer, ChatRoom> chatRooms = new HashMap<>();

	public void addChatRoom(ChatRoom chatRoom) {
		chatRooms.put(chatRoom.getRoomNumber(), chatRoom);
	}
	public Map<Integer, ChatRoom> getChatRooms() {return chatRooms;}
}
