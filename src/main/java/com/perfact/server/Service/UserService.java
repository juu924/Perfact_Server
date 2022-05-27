package com.perfact.server.Service;

import com.perfact.server.domain.User;
import com.perfact.server.domain.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String login(String email, String password) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.get().getPasswd().equals(password)) {
            return "Success";
        }
        return "Failed";
    }

    public Long getMemberId(String email){
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.get().getId();
    }

}
