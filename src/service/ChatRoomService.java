package service;

import static validator.RoomNameValidator.*;

import java.io.IOException;

import model.ChatRoom;
import repository.ChatRoomRepository;

public class ChatRoomService {
	private final ChatRoomRepository chatRoomRepository = new ChatRoomRepository();

	public void createChatRoom(String roomName) {
		ChatRoom chatRoom = new ChatRoom(roomName);
		chatRoomRepository.addChatRoom(chatRoom);
	}
}
