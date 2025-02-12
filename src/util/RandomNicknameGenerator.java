package util;
import java.util.Random;

public class RandomNicknameGenerator {
	public static String generateNickname() {
		Random random = new Random();
		int number = 10000000 + random.nextInt(90000000); // 8자리 랜덤 숫자 (10000000 ~ 99999999)
		return "Anonymous" + number;
	}
}
