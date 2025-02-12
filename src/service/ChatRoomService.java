package service;

import static validator.RoomNameValidator.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.ChatRoom;
import repository.ChatRoomRepository;

public class ChatRoomService {
	private static final ChatRoomRepository chatRoomRepository = new ChatRoomRepository();

	public void createChatRoom(ChatRoom chatRoom) {
		chatRoomRepository.addChatRoom(chatRoom);
	}

	public Map<Integer,ChatRoom> getChatRooms() {
		return chatRoomRepository.getChatRooms();
	}

	public Set<Integer> getChatRoomId() {
		return chatRoomRepository.getChatRoomId();
	}
}
