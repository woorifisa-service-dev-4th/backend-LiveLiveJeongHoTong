
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    }


