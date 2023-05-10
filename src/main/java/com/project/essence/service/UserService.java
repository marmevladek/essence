package com.project.essence.service;

import com.project.essence.model.User;
import com.project.essence.model.enums.Role;
import com.project.essence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user, boolean admin) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email)!=null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (admin) user.getRoles().add(Role.ROLE_ADMIN);
        user.getRoles().add(Role.ROLE_ADMIN);
        log.info("Saving new User with email {}", email);
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user {}; {}", user.getId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user {}; {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }
}
