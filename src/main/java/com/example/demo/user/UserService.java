package com.example.demo.user;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // ID로 사용자 조회
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    // 이메일로 사용자 조회
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // 사용자 생성
    public User createUser(User user) {
        // 이메일 중복 체크
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일입니다: " + user.getEmail());
        }
        return userRepository.save(user);
    }
    
    // 사용자 정보 수정
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));
        
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        
        return userRepository.save(user);
    }
    
    // 사용자 삭제
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));
        
        userRepository.delete(user);
    }
    
    // 이름으로 사용자 검색
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name)
                .map(List::of)
                .orElse(List.of());
    }
}

