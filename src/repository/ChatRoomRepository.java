package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ChatRoom;

public class ChatRoomRepository {
	private final Map<Integer, ChatRoom> chatRooms = new HashMap<>();

	public void addChatRoom(ChatRoom chatRoom) {
		chatRooms.put(chatRoom.getRoomNumber(), chatRoom);
	}
	public Map<Integer, ChatRoom> getChatRooms() {return chatRooms;}

	public Set<Integer> getChatRoomId() {return chatRooms.keySet();}
}
