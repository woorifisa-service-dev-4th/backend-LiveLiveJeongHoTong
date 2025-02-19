import data.HostDto;
import model.Host;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import repository.HostRepository;
import service.HostService;
import util.PasswordDigestUtil;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HostServiceTestV2 {

    @InjectMocks
    private HostService hostService;
    @Mock
    private HostRepository hostRepositoryMock;
    @Mock
    private PasswordDigestUtil passwordDigestUtilMock;



    @Test
    @DisplayName("올바른 이메일 형식을 갖춰 아이디를 입력했을 시 회원가입이 성공한다")
    void should_CreateHost_When_InputOK() {
        // given
        String email = "gugugu@naver.com";
        String password = "pigeongugu";

        // when
        boolean result = hostService.createHost(email, password);

        // then
        assertTrue(result);


    }


//    @Test
//    @DisplayName("중복된 이메일이면 회원가입이 실패하고 false 값을 반환한다.")
//    void should_Fail_When_DuplicateHost() {
//        // Given
//        String email = "gugugu@naver.com";
//        String password = "pigeongugu";
//
//    }



}
