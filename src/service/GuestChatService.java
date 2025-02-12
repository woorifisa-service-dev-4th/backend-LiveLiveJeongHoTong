package service;

import model.ChatMessage;
import model.Guest;
import model.Host;
import model.Person;
import model.enumtype.MessageType;
import service.validator.GuestValidator;

import java.io.*;
import java.util.*;
public class GuestChatService {

    private GuestValidator guestValidator;
    private List<Guest> guestList;
    private List<ChatMessage> chatList;

    private Scanner scanner;

    public GuestChatService() {
        this.guestValidator = new GuestValidator();
        this.guestList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void enter(int roomNumber) {
        Guest guest = new Guest(roomNumber);
        guestList.add(guest);
        System.out.println("입장하신 방 번호는 " + roomNumber + " 입니다.");
        System.out.println("입장하신 닉네임은 " + guest.getNickname()+ " 입니다.");
        chatList.add(new ChatMessage("강사", "안녕하세요! 무엇을 도와드릴까요?", MessageType.REQ));
        chatList.add(new ChatMessage("Anonymous64639307", "안녕하세요! 질문이 있습니다.", MessageType.RES));
        chatList.add(new ChatMessage("강사", "네? 질문해주세요.", MessageType.REQ));
        chatList.add(new ChatMessage("Anonymous64639307", "이 코드를 어떻게 개선할 수 있을까요?", MessageType.RES));
        chat(guest); // 입장 후 채팅 시작
    }

    public void chat(Guest guest) {
        System.out.println("채팅을 시작합니다. (종료하려면 엔터 입력)");

        while (true) {
            for (ChatMessage chatMessage : chatList) {
                if (chatMessage.getType() == MessageType.RES) {
                    System.out.println("강사: " + chatMessage.getContent());
                } else {
                    System.out.println("                           "+guest.getNickname() + ": " + chatMessage.getContent());
                }
            }
            System.out.print("채팅 입력: ");
            String message = scanner.nextLine();

            if (message.isEmpty()) {
                System.out.println("채팅을 종료합니다.");
                break;
            }
            // 출력 형식 맞춤


            // 유저 메시지 기록
            MessageType messageType = MessageType.REQ;
            ChatMessage userMessage = new ChatMessage(guest.getNickname(), message, messageType);
            chatList.add(userMessage); // 메시지 저장



        }
    }
}
