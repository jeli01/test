package start.startspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.startspring.repository.MemoryMessageRepository;

@RequiredArgsConstructor
@Service
public class MessageService {
    public final MemoryMessageRepository messageRepository;

    
}
