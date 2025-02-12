package validator;

import java.io.IOException;

import model.ChatRoom;

public class InputNameValidator {
	public static boolean isOptionValid(String options) throws IOException {
		if (!options.equals("1") && !options.equals("2")) {
			throw new IOException("⚠ 입력 오류: 잘못된 입력입니다. 1 또는 2를 입력하세요.\n");
		}
		return true;
	}
}
