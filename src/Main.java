import static executor.Executor.*;
import model.Guest;
import model.Host;
import model.Person;
import service.GuestChatService;
import system.LandingSystem;

public class Main {
	public static void main(String[] args) {
    LandingSystem landingSystem = new LandingSystem();
    landingSystem.run();

		Person p = new Host(1,"@gmail.com","1234");

		startChat(p);
	}

}
