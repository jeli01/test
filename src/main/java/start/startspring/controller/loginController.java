package start.startspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import start.startspring.domain.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import start.startspring.domain.Member;
import start.startspring.repository.MemoryMemberRepository;
import start.startspring.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class loginController {

    private final MemoryMemberRepository memoryMemberRepository;
    private final LoginService loginService;
    @PostMapping("/sign-up")
    public String sineUp(@ModelAttribute Member member) {
        memoryMemberRepository.save(member);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, HttpServletRequest request) {
        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        if (loginMember == null) {
            return "redirect:/";
        }

        // 여기서 부터 로그인 성공!

        HttpSession session = request.getSession();
        session.setAttribute("123", loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
