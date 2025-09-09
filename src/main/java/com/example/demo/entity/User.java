package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Schema(description = "사용자 정보")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "사용자 고유 ID", example = "1")
    private Long id;
    
    @Column(nullable = false, unique = true)
    @Schema(description = "사용자 이메일", example = "user@example.com", required = true)
    private String email;
    
    @Column(nullable = false)
    @Schema(description = "사용자 이름", example = "홍길동", required = true)
    private String name;
    
    @Column
    @Schema(description = "사용자 나이", example = "25")
    private Integer age;
    
    // 기본 생성자
    public User() {}
    
    // 생성자
    public User(String email, String name, Integer age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }
    
    // Getter와 Setter
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

