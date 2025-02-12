package util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/*
 1. sha-256 인스턴스 객체 생성
 2. 솔트값 생성 및 해싱 로직
 3. 검증
 */
public class PasswordDigestUtil {

    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 16;

    // SALT 값 생성
    public String generateSalt() {

       Base64.Encoder encoder = Base64.getEncoder();

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return encoder.encodeToString(salt);
    }


    // 비밀번호 해싱하기
    public String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt.getBytes());
            byte[] hashpwd = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashpwd);
        } catch( NoSuchAlgorithmException e) {
            throw new RuntimeException("비밀번호 해싱 실패", e);
        }


    }


}
