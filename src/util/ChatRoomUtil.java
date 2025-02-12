package util;

public class ChatRoomUtil {
    public static int createChatRoomNumber() {
        return (int) (Math.random() * 999_999_999);
    }
}
