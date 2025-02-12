package validator;

import java.io.IOException;
import java.util.Objects;

public class MenuValidator {


    public static boolean validateMainMenu(String input) throws IOException {
        input = Objects.requireNonNull(input, "⚠ 입력 오류: 입력값이 null입니다.\n");
        if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            throw new IOException("⚠ 입력 오류: 잘못된 메뉴 선택입니다. 1, 2, 3 중 하나를 입력하세요.\n");
        }
        return true;
    }

    public static boolean validateHostMenu(String input) throws IOException {
        input = Objects.requireNonNull(input, "⚠ 입력 오류: 입력값이 null입니다.\n");
        if (!input.equals("1") && !input.equals("2") && !input.equals("3")
                && !input.equals("4") && !input.equals("admin")) {
            throw new IOException("⚠ 입력 오류: 잘못된 메뉴 선택입니다. 1, 2, 3, 4 중 하나를 입력하세요.\n");
        }
        return true;
    }
}
