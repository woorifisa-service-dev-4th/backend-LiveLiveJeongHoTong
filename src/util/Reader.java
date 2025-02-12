package util;

import static validator.InputNameValidator.*;
import static validator.RoomNameValidator.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.ChatRoom;

public class Reader {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int optionsReader() {
		int ret;
		while (true) {
			try {
				System.out.print("번호를 입력하세요: ");
				String input = br.readLine();
				System.out.println();

				isOptionValid(input);
				ret = Integer.parseInt(input);

				break;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return ret;
	}
	public static String roomNameReader() {
		String input;
		while (true) {
			try {
				System.out.print("생성하실 방 이름을 입력하세요: ");
				input = br.readLine();
				System.out.println();
				isRoomNameValid(input);

				break;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return input;
	}
}

