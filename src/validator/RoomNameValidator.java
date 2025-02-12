package validator;

import java.io.IOException;

public class RoomNameValidator {
	public static void isRoomNameValid(String roomName) throws IOException{
		if(roomName.isEmpty())
			throw new IOException("⚠ 입력 오류: 잘못된 입력입니다. 1글자 이상 입력하세요.\n");
	}
}
