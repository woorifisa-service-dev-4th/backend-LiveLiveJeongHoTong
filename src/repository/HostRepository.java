package repository;

import java.util.ArrayList;

public class HostRepository {

    private static ArrayList<String[]> HostData = new ArrayList<>();

    // 새로운 id 값 생성
    public int getAutoId() {
        int maxId = 0;
        for(String[] row : HostData) {
            int currendId = Integer.parseInt(row[0]);
            if(currendId > maxId) {
                maxId = currendId;
            }
        }
        return maxId + 1;
    }

    // 호스트 계정 생성
    public void setHost(int id, String email, String hashing_passwd, String SALT) {
        String[] temp = {String.valueOf(id), email , hashing_passwd, SALT};
        HostData.add(temp);
    }


    // 들어온 id와 비밀번호가 일치하는지 검증
    public boolean check(String email, String hashing_passwd) {
        for(int i=0 ; i<HostData.size() ; i++) {
            if(email.equals(HostData.get(i)[1])) {
                if(hashing_passwd.equals(HostData.get(i)[2])) {
                    return true;
                }
            }
        }
        return false;
    }


    // 해당 id의 SALT값 찾기
    public String getSalt(String email) {
        String salt = null;
        for(int i=0 ; i<HostData.size() ; i++) {
            if(email.equals(HostData.get(i)[1])) {
                salt = HostData.get(i)[3];
                break;
            }
        }
        return salt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String[] temp : HostData) {
            sb.append("email : " +temp[1] + "\tPassword : " + temp[2] + "\tSALT : "+ temp[3]).append("\n\n");
        }
        return sb.toString();
    }
}