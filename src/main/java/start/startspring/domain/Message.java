package start.startspring.domain;

import lombok.Data;

@Data
public class Message {
    Long id;
    Long roomId;
    String name;
    String content;
}
