package start.startspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import start.startspring.domain.Member;
import start.startspring.repository.MemoryMemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class MainController {

    public final MemoryMemberRepository memoryMemberRepository;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return "index";
        }
        
        // 세션이 있다면

        Member loginMember = (Member) session.getAttribute("123");
        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "index";
        }

        //세션도 있고 회원 데이터도 있으면
        List<Member> members;
        members = memoryMemberRepository.findAll();

        model.addAttribute("member", loginMember);
        model.addAttribute("members", members);
        return "loginIndex";
    }

}
