package executor;

import executor.handler.DefaultUserInputHandler;
import executor.handler.UserInputHandler;
import service.HostService;
import java.util.Scanner;


/*

 -회원가입
ID를 입력해주세요:
비밀번호를 입력해주세요:
-> host 생성 메서드 필요
 */
public class SignUpExecutor {

    static Scanner in  = new Scanner(System.in);
    private final UserInputHandler inputHandler;
    private final HostService hostService;

    public SignUpExecutor(HostService hostService) {
        this.hostService = hostService;
        this.inputHandler = new DefaultUserInputHandler(
                new Scanner(System.in),
                "아이디 입력 >>>>>>>>>>>  ",
                "비밀번호 입력 >>>>>>>>>>>   "
        );
    }

    public void make_host() {
        boolean signupSuccess = false;
        while (!signupSuccess) {
            String email = inputHandler.getEmail();
            String password = inputHandler.getPassword();
            signupSuccess = hostService.createHost(email, password);
        }
    }

}
