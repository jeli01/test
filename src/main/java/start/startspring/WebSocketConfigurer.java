package start.startspring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import start.startspring.handler.ChatHandler;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfigurer implements org.springframework.web.socket.config.annotation.WebSocketConfigurer{
    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/ws/Chat").setAllowedOrigins("*");
    }
}

