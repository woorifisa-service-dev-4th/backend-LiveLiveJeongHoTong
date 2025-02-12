package validator;

public class HostValidator {

    public static void validateEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("이메일을 입력해주세요.");
        }
        if(!email.contains("@")) {
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다");
        }
    }

    public static void validatePassword(String password) {
        if(password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요");
        }
    }

    public static void validateDuplicateEmail(String salt) {
        if(salt != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다");
        }
    }

    public static void validateExistingUser(String salt) {
        if(salt == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다");
        }
    }
}
