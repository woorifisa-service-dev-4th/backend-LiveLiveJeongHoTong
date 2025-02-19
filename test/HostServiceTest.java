
import model.Host;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import repository.HostRepository;
import service.HostService;
import util.PasswordDigestUtil;


import static org.junit.jupiter.api.Assertions.*;

public class HostServiceTest {


    private HostService hostService;


    @BeforeEach
    void setUp() {
        HostRepository mockRepository = new HostRepository();
        PasswordDigestUtil passwordDigestUtil = new PasswordDigestUtil();
        hostService = new HostService(mockRepository, passwordDigestUtil);
    }



    @DisplayName("올바른 이메일 형식을 갖춰 아이디를 입력했을 시 회원가입이 성공한다")
    @Test
    void testCreateHost_Success() {
        assertTrue(hostService.createHost("gugugu@naver.com", "pigeongugu"));
    }



    @Disabled
    @DisplayName("중복된 이메일이면 회원가입이 실패한다.")
    @Test
    void testValidateDuplicateEmail_Failure() {

        String email = "gugugu@naver.com";
        String password = "pigeongugu";

        hostService.createHost(email, password);

        // 콜백함수로 정의
        boolean result = hostService.createHost(email, password);

        assertFalse(result);
    }

    // 로그인 Test

    @Disabled
    @DisplayName("올바른 아이디 및 비밀번호를 입력했을 시 회원가입이 성공한다")
    @Test
    void testloginHost_Success() {

        String email = "gugugu@naver.com";
        String password = "gugugu";

        hostService.createHost(email, password);

        assertTrue(hostService.loginHost("gugugu@naver.com", "gugugu"));
    }


    @Disabled
    @Test
    @DisplayName("전달된 아이디의 값이 0일 경우, false값을 반환한다")
    void testloginHost_Failure() {

        String email = "gugugu@naver.com";
        String password = "gugugu";

        hostService.createHost(email, password);

        assertFalse(hostService.loginHost("", "gugugu"));
    }


}
