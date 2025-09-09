package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // 기존 데이터가 없을 때만 테스트 데이터 생성
        if (userRepository.count() == 0) {
            createTestUsers();
            System.out.println("테스트 데이터가 성공적으로 생성되었습니다!");
        }
    }
    
    private void createTestUsers() {
        // 테스트 사용자들 생성
        User user1 = new User("hong@example.com", "홍길동", 25);
        User user2 = new User("kim@example.com", "김철수", 30);
        User user3 = new User("lee@example.com", "이영희", 28);
        User user4 = new User("park@example.com", "박민수", 35);
        User user5 = new User("choi@example.com", "최지영", 22);
        
        // 데이터베이스에 저장
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        
        System.out.println("생성된 테스트 사용자:");
        System.out.println("1. 홍길동 (hong@example.com, 25세)");
        System.out.println("2. 김철수 (kim@example.com, 30세)");
        System.out.println("3. 이영희 (lee@example.com, 28세)");
        System.out.println("4. 박민수 (park@example.com, 35세)");
        System.out.println("5. 최지영 (choi@example.com, 22세)");
    }
}




