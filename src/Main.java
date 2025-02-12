import executor.Executor;
import model.Guest;
import model.Host;
import model.Person;
import service.GuestChatService;

public class Main {
	public static void main(String[] args) {
		Executor executor = new Executor();

		// 1. 유저타입을 선택하세요

		// 강사 - 회원가입, 로그인

		// 로그인 - 강사

		// 1. 채팅방 만들기 2. 채팅방 입장하기
		Person p = new Host(1,"@gmail.com","1234");

		executor.startChat(p);
	}
}
