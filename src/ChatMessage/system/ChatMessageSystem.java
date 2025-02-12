package ChatMessage.system;

import ChatMessage.model.ChatMessage;
import ChatMessage.model.MessageType;

public class ChatMessageSystem {


    public static void main(String[] args) {

        ChatMessage msg1 = new ChatMessage("두팔이", "이 문제 어떻게 풀까요?", MessageType.REQ);
        ChatMessage msg2 = new ChatMessage("You정호", "이렇게 하면 될 것 같아요!", MessageType.RES);

        System.out.println(msg1);
        System.out.println(msg2);
    }
}
