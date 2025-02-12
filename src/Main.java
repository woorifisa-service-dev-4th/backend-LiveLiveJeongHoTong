import service.GuestChatService;

public class Main {
	public static void main(String[] args) {
		GuestChatService service = new GuestChatService();

		service.enter(100);

		System.out.println("Hello world!");
	}
}
