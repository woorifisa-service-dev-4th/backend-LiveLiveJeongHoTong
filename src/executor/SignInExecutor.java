package executor;

import executor.handler.DefaultUserInputHandler;
import executor.handler.UserInputHandler;
import service.HostService;
import java.util.Scanner;
/*

- 로그인
ID를 입력해주세요:
비밀번호를 입력해주세요:
-> host 계정 검증 메서드
*/
public class SignInExecutor {

    private final UserInputHandler inputHandler;
    private final HostService hostService;
    static Scanner in = new Scanner(System.in);

    public SignInExecutor(HostService hostService) {
        this.hostService = hostService;
        this.inputHandler = new DefaultUserInputHandler(
                new Scanner(System.in),
                "아이디 입력 >>>>>>>>>>>  ",
                "비밀번호 입력 >>>>>>>>>>>   "
        );
    }

    public boolean login() {
        boolean loginSuccess = false;
        while (!loginSuccess) {
            String email = inputHandler.getEmail();
            String password = inputHandler.getPassword();
            loginSuccess = hostService.loginHost(email, password);
        }
        return true;
    }

}

