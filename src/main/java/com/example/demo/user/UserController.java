package com.example.demo.user;

import com.example.demo.user.dto.Response;
import com.example.demo.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // CORS 설정 (개발용)
@Tag(name = "User Management", description="사용자 관리 API")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    // 모든 사용자 조회
    @GetMapping
    @Operation(summary="사용자 전체 조회")
    @ApiResponse(responseCode="200", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.GetAllUsersOK.class)))
    public ResponseEntity<Response.GetAllUsersOK> getAllUsers(

    ) {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new Response.GetAllUsersOK(users));
    }
    
    // ID로 사용자 조회
    @GetMapping("/{id}")
    @Operation(summary="ID로 사용자 조회", description="사용자 ID를 통해 특정 사용자 정보를 조회합니다.")
    @ApiResponse(responseCode="200", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.GetUserByIdOK.class)))
    @ApiResponse(responseCode="404", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.UserNotFound.class)))
    public ResponseEntity<?> getUserById(
        @Parameter(description="사용자 ID", required=true, example="1")
        @PathVariable Long id
    ) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new Response.GetUserByIdOK(user.get()));
        } else {
            return ResponseEntity.status(404).body(new Response.UserNotFound());
        }
    }
    

    
    // 사용자 생성
    @PostMapping
    @Operation(summary="사용자 생성", description="새로운 사용자를 생성합니다.")
    @ApiResponse(responseCode="201", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.CreateUserOK.class)))
    @ApiResponse(responseCode="400", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.CreateUserFail.class)))
    public ResponseEntity<?> createUser(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "생성할 사용자 정보",
            required=true,
            content=@Content(schema=@Schema(implementation = User.class))
        )
        @RequestBody User user
    ) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response.CreateUserOK(createdUser));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new Response.CreateUserFail());
        }
    }
    
    // 사용자 정보 수정
    @PutMapping("/{id}")
    @Operation(summary="사용자 정보 수정", description="기존 사용자의 정보를 수정합니다.")
    @ApiResponse(responseCode="200", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.UpdateUserOK.class)))
    @ApiResponse(responseCode="400", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.UpdateUserFail.class)))
    public ResponseEntity<?> updateUser(
        @Parameter(description="사용자 ID", required = true, example = "1")
        @PathVariable Long id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "수정할 사용자 정보",
            required=true,
            content=@Content(schema=@Schema(implementation=User.class))
        )
        @RequestBody User userDetails
    ) {
        try {
            User updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(new Response.UpdateUserOK(updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new Response.UpdateUserFail());
        }
    }
    
    // 사용자 삭제
    @DeleteMapping("/{id}")
    @Operation(summary="사용자 삭제", description="특정 사용자를 삭제합니다.")
    @ApiResponse(responseCode="200", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.DeleteUserOK.class)))
    @ApiResponse(responseCode="400", content=@Content(mediaType="application/json", schema=@Schema(implementation=Response.DeleteUserFail.class)))
    public ResponseEntity<?> deleteUser(
        @Parameter(description="사용자 ID", required = true, example = "1")
        @PathVariable Long id
    ) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(new Response.DeleteUserOK());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new Response.DeleteUserFail());
        }
    }
}

