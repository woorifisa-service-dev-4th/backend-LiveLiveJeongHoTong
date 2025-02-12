package util;

import static validator.InputNameValidator.*;
import static validator.RoomNameValidator.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.ChatRoom;

public class Reader {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int optionsReader(String msg) {
		int ret;
		while (true) {
			try {
				System.out.print(msg);
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

	public static int roomNumberReader() {
		int input;
		while (true) {
			try {
				System.out.print("입장하실 방 번호 입력하세요: ");
				input = Integer.parseInt(br.readLine());
				System.out.println();
				break;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return input;
	}
}


