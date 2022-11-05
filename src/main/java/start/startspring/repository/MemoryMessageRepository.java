package start.startspring.repository;

import org.springframework.stereotype.Repository;
import start.startspring.domain.Message;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMessageRepository {
    private static List<Message> messages = new ArrayList<>();
    private static Long sequence = 0L;

    public void add(Long roomId, String name, String content) {
        Message message = new Message();
        message.setId(sequence++);
        message.setRoomId(roomId);
        message.setName(name);
        message.setContent(content);

        messages.add(message);
    }

    public void findRoomMessage() {

    }

}
