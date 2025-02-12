package system;

import processor.HostService;
import java.util.Scanner;


/*

 -회원가입
ID를 입력해주세요:
비밀번호를 입력해주세요:
-> host 생성 메서드 필요
 */
public class SignUpSystem {

    static Scanner in  = new Scanner(System.in);
    private final UserInputHandler inputHandler;
    private final HostService hostService;

    public SignUpSystem(HostService hostService) {
        this.hostService = hostService;
        this.inputHandler = new DefaultUserInputHandler(
                new Scanner(System.in),
                "아이디 입력 >>>>>>>>>>>  ",
                "비밀번호 입력 >>>>>>>>>>>   "
        );
    }

    public void make_host() {
        String email = inputHandler.getEmail();
        String password = inputHandler.getPassword();
        hostService.createHost(email, password);
    }

}
