package executor;

import service.HostService;
import repository.HostRepository;
import util.PasswordDigestUtil;
import validator.MenuValidator;

import java.io.IOException;
import java.util.Scanner;

import static executor.Executor.startChat;

public class MainExecutor {

    private static final Scanner in = new Scanner(System.in);
    private static final HostRepository hostDB = new HostRepository();
    private static final PasswordDigestUtil digestUtil = new PasswordDigestUtil();
    private static final HostService hostService = new HostService(hostDB, digestUtil);
    private static final SignInExecutor signin = new SignInExecutor(hostService);
    private static final SignUpExecutor signup = new SignUpExecutor(hostService);

    public static void run() {
        boolean running = true;
        String n;
        while (running) {
            System.out.print("유저타입을 선택하세요 \t 1. 강사 \t  2. 학생");
            System.out.println("\t >>>>>>  ");

             n = in.nextLine();

            try {
                MenuValidator.validateMainMenu(n);

                if (n.equals("1")) {
                    handleHostMenu(n);
                } else if (n.equals("2")) {
                    System.out.println("학생 페이지로 이동합니다");
                    startChat(n);
                    running = false;
                } else if (n.equals("3")) {
                    System.out.println("프로그램을 종료합니다");
                    running = false;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void handleHostMenu(String p) {
        while (true) {
            System.out.print("1. 회원가입 \t  2. 로그인 \t  3. 돌아가기 \t  4. 종료");
            System.out.println("\t >>>>>>  ");
            String n = in.nextLine();

            try {
                MenuValidator.validateHostMenu(n);

                if (n.equals("1")) {
                    signup.make_host();
                } else if (n.equals("2")) {
                    boolean loginSuccess = signin.login();
                    if (loginSuccess) startChat(p);
                } else if (n.equals("3")) {
                    return;
                } else if (n.equals("4")) {
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                } else if (n.equals("admin")) {
                    System.out.println(hostService.getHostDB());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        }
    }

