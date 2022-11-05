package start.startspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.startspring.domain.Member;
import start.startspring.repository.MemoryMemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemoryMemberRepository memoryMemberRepository;

    public Member login(String loginId, String password) {
        return memoryMemberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
