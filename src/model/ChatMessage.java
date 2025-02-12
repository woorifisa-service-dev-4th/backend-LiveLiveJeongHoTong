package model;

/*/채팅 클래스
Class Summary
채팅은 내용을 관리하고 답글과 질문을 구분할 수 있다.

Field Summary
- author: 채팅을 작성한 사람에 대한 정보
- content: 채팅 내용
- type: 답장 혹은 질문을 구분

Method Summary
- getContent(): 채팅의 내용을 읽어온다.
- setContent(): 채팅의 내용을 정한다.
*/

import model.enumtype.MessageType;

import java.time.LocalDateTime;

public class ChatMessage {

    private String author;
    private String content;
    private MessageType messagetype;
    private LocalDateTime timestamp;


    public ChatMessage(String author, String content, MessageType messagetype) {
        this.author = author;
        this.content = content;
        this.messagetype = messagetype;
        this.timestamp = LocalDateTime.now();
    }


    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return messagetype;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + author + " (" + messagetype + "): " + content;
    }

}
