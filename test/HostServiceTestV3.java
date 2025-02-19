import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ChatRoomRepository;
import service.ChatRoomService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static validator.InputNameValidator.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
class HostServiceTestV3 {
    @Mock
    ChatRoomService chatRoomService;

    @Mock
    ChatRoomRepository chatRoomRepository;

    @Test
    @DisplayName("올바른 옵션을 입력하지않으면 ⚠ 입력 오류: 잘못된 입력입니다. 1 또는 2를 입력하세요. 가 출력된다.")

    void enter_Invalid_Option_Should_Print_InfoMessage() {
        //given
        String input = "잘못된 입력";
        String actual;
        String expected = "⚠ 입력 오류: 잘못된 입력입니다. 1 또는 2를 입력하세요.\n";
        //when
        actual = isOptionValidString(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("올바른 옵션을 입력하면 올바른 입력입니다 가 출력된다.")
    void enter_Right_Option_Should_Print_InfoMessage() {
        //given
        String input = "1";
        String actual;
        String expected = "올바른 입력입니다.";

        //when
        actual = isOptionValidString(input);

        //then
        assertEquals(expected, actual);
    }

    @Disabled
    @Test
    @DisplayName("채팅방을 생성하면 id를 리턴한다.")
    void call_createChatRoom_Should_Return_ChatRoomName() {
        when(this.chatRoomService.createChatRoom(null)).thenReturn(1);
//        given(chatRoomService.createChatRoom())
    }
}
