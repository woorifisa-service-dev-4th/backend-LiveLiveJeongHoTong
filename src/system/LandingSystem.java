package system;

import processor.HostService;
import repository.HostDB;
import util.PasswordDigestUtil;

import java.util.Scanner;

import static executor.Executor.startChat;

public class LandingSystem {

    private final Scanner in;
    private final SigninSystem signin;
    private final SignUpSystem signup;
    private final HostService hostService;

    public LandingSystem() {
        this.in = new Scanner(System.in);

        HostDB hostDB = new HostDB();
        PasswordDigestUtil digestUtil = new PasswordDigestUtil();
        this.hostService = new HostService(hostDB, digestUtil);
        this.signin = new SigninSystem(hostService);
        this.signup = new SignUpSystem(hostService);
    }


    public void run() {
        boolean running = true;
        String n;
        while (running) {
            System.out.print("유저타입을 선택하세요 \t 1. 강사 \t  2. 학생");
            System.out.println("\t >>>>>>  ");

             n = in.nextLine();

            if (n.equals("1")) {
                handleHostMenu(n);
            } else if (n.equals("2")) {
                System.out.println("학생 페이지로 이동합니다");
                startChat(n);
                running = false;
            } else if (n.equals("3")) {
                System.out.println("프로그램을 종료합니다");
                running = false;
            } else {
                System.out.println("잘못 입력");
                System.out.println();
            }
        }
    }

    private void handleHostMenu(String p) {
        while(true) {
            System.out.print("1. 회원가입 \t  2. 로그인 \t  3. 돌아가기\t  4. 종료");
            System.out.println("\t >>>>>>  ");
            String n = in.nextLine();

            if(n.equals("1")) {
                signup.make_host();
            }
            else if(n.equals("2")) {
                signin.login();
                startChat(p);
            }
            else if(n.equals("3")) {
                return;
            }
            else if(n.equals("4")) {
                System.out.println("프로그램을 종료합니다");
                System.exit(0);
            }
            else if(n.equals("admin")) {
                System.out.println(hostService.getHostDB());
            }
            else {
                System.out.println("잘못 입력");
            }

        }
    }


}
