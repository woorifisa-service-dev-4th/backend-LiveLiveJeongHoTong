package processor;

import model.Host;
import model.Person;
import repository.HostDB;
import util.PasswordDigestUtil;

public class HostService {

    private final HostDB hostDB;
    private final PasswordDigestUtil passwordDigestUtil;

    public HostService(HostDB hostDB, PasswordDigestUtil passwordDigestUtil) {
        this.hostDB = hostDB;
        this.passwordDigestUtil = passwordDigestUtil;
    }

    public Host createHost(String email, String password) {
        try {
            // 이메일 형식 검증
            if( email == null || email.isEmpty() ) {
                throw new IllegalArgumentException("이메일을 입력해주세요.");
            }
            if(!email.contains("@")) {
                throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다");
            }

            // 비밀번호 검증
            if( password == null || password.trim().isEmpty() ) {
                throw new IllegalArgumentException("비밀번호를 입력해주세요");
            }

            // 중복 이메일 체크
            if(hostDB.get_SALT(email) != null) {
                throw new IllegalArgumentException("이미 존재하는 이메일입니다");
            }

            // host 객체 생성
            Host host = new Host(email);
            int nextId = hostDB.getAutoId();
            host.setId(nextId);

            // 입력된 비밀번호 + salt값 생성
            String salt = passwordDigestUtil.generateSalt();
            String hashedPassword = passwordDigestUtil.hashPassword(password, salt);
            hostDB.set_HOST(host.getId(), email, hashedPassword, salt);
            System.out.println("회원가입이 성공적으로 완료되었습니다");
            return host;


        }catch(IllegalArgumentException e) {
            System.out.println("회원가입 실패: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("회원가입 중 오류 발생" + e.getMessage());
            return null;
        }

    }

    public boolean loginHost(String email, String password) {
        try {

            // 이메일 및 비번 입력 여부 체크
            if(email == null || email.trim().isEmpty() ) {
                throw new IllegalArgumentException("이메일을 입력해주세요. ");
            }
            if(password == null || password.trim().isEmpty() ) {
                throw new IllegalArgumentException("비밀번호를 입력해주세요");
            }
            String temp_salt = hostDB.get_SALT(email);
            if (temp_salt == null) {
               throw new IllegalArgumentException("존재하지 않는 사용자입니다");
            }
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
            System.out.println("로그인 실패" + e.getMessage());
            return false;
        }catch(Exception e) {
            System.out.println(("로그인 중 오류 발생" + e.getMessage()));
            return false;
        }



    }

    public String getHostDB() {
        return hostDB.toString();
    }


}
