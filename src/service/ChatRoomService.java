package service;

import static validator.RoomNameValidator.*;

import java.io.IOException;

import model.ChatRoom;
import repository.ChatRoomRepository;

public class ChatRoomService {
	private final ChatRoomRepository chatRoomRepository = new ChatRoomRepository();

	public void createChatRoom(String roomName) throws IOException {
		if(!validateRoomName(roomName)){
			throw new IOException("1글자 이상 입력해주세요");
		}
		ChatRoom chatRoom = new ChatRoom(roomName);
		chatRoomRepository.addChatRoom(chatRoom);
	}
}
