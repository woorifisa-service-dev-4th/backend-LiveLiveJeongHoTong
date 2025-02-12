package service;

import model.Host;
import repository.HostRepository;
import util.PasswordDigestUtil;
import validator.HostValidator;

public class HostService {

    private final HostRepository hostDB;
    private final PasswordDigestUtil passwordDigestUtil;

    public HostService(HostRepository hostDB, PasswordDigestUtil passwordDigestUtil) {
        this.hostDB = hostDB;
        this.passwordDigestUtil = passwordDigestUtil;
    }

    public boolean createHost(String email, String password) {
        try {

            // 입력 유효성 검증
            HostValidator.validateEmail(email);
            HostValidator.validatePassword(password);
            HostValidator.validateDuplicateEmail(hostDB.getSalt(email));

            // host 객체 생성
            Host host = new Host(email);
            int nextId = hostDB.getAutoId();
            host.setId(nextId);

            // 입력된 비밀번호 + salt값 생성
            String salt = passwordDigestUtil.generateSalt();
            String hashedPassword = passwordDigestUtil.hashPassword(password, salt);
            hostDB.setHost(host.getId(), email, hashedPassword, salt);
            System.out.println("회원가입이 성공적으로 완료되었습니다");
            return true;


        }catch(IllegalArgumentException e) {
            System.out.println("회원가입 실패: \t " + e.getMessage());
            return false;
        }
    }

    public boolean loginHost(String email, String password) {
        try {
            // 유효성 검증
            HostValidator.validateEmail(email);
            HostValidator.validatePassword(password);

            String temp_salt = hostDB.getSalt(email);
            HostValidator.validateExistingUser(temp_salt);

            // 임시 해싱 값 생성 및 일치 체크
            String temp_pass = passwordDigestUtil.hashPassword(password, temp_salt);
            boolean loginSuccess = hostDB.check(email, temp_pass);

            if(loginSuccess) {
                System.out.println("로그인 성공");
                return true;
            } else {
               throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
            }
        }catch(IllegalArgumentException e) {
            System.out.println("로그인 실패: \t" + e.getMessage());
            return false;
        }



    }

    public String getHostDB() {
        return hostDB.toString();
    }


}
