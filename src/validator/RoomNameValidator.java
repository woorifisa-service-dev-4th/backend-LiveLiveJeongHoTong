package validator;

import java.io.IOException;
import java.util.Objects;

public class RoomNameValidator {
	public static void isRoomNameValid(String roomName) throws IOException{
		roomName = Objects.requireNonNull(roomName, "⚠ 입력 오류: 잘못된 입력입니다.\n"); // NPE 발생
		if(roomName.isEmpty())
			throw new IOException("⚠ 입력 오류: 잘못된 입력입니다. 1글자 이상 입력하세요.\n");
	}

}
