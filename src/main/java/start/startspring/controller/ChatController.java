package start.startspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ChatController {


    @GetMapping("/chat/room")
    public String showRoom(Model model) {
        model.addAttribute("message","123");
        return "chat/room";
    }

}
