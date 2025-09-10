package com.example.demo.user.dto;

import com.example.demo.dto.RootResponse;
import com.example.demo.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

public class Response {
    /* GetAllUsers */
    @Schema(description="사용자 목록 조회 성공 응답")
    public static class GetAllUsersOK extends RootResponse.OK<List<User>> {
        public GetAllUsersOK(List<User> data) {
            super(data);
        }

        @Schema(example="GetAllUsersOK")
        private String label = "GetAllUsersOK";

        @Schema(example="사용자 목록을 조회했습니다")
        private String message = "사용자 목록을 조회했습니다";
    }


    /* GetUserById */
    @Schema(description="사용자를 찾을 수 없음 응답")
    public static class UserNotFound extends RootResponse.NotFound {
        @Schema(example="UserNotFound")
        private String label = "UserNotFound";

        @Schema(example="해당 사용자를 찾을 수 없습니다")
        private String message = "해당 사용자를 찾을 수 없습니다";
    }

    @Schema(description="사용자 정보 조회 성공 응답")
    public static class GetUserByIdOK extends RootResponse.OK<User> {        
        public GetUserByIdOK(User data) {
            super(data);
        }

        @Schema(example="GetUserByIdOK")
        private String label = "GetUserByIdOK";

        @Schema(example="사용자 정보를 조회했습니다")
        private String message = "사용자 정보를 조회했습니다";
    }


    /* CreateUser */
    @Schema(description="사용자 생성 성공 응답")
    public static class CreateUserOK extends RootResponse.OK<User> {        
        public CreateUserOK(User data) {
            super(data);
        }

        @Schema(example="CreateUserOK")
        private String label = "CreateUserOK";

        @Schema(example="사용자를 생성했습니다")
        private String message = "사용자를 생성했습니다";
    }

    @Schema(description="사용자 생성 실패 응답")
    public static class CreateUserFail extends RootResponse.BadRequest {
        @Schema(example="CreateUserFail")
        private String label = "CreateUserFail";

        @Schema(example="사용자 생성에 실패했습니다")
        private String message = "사용자 생성에 실패했습니다";
    }


    /* UpdateUser */
    @Schema(description="사용자 정보 수정 성공 응답")
    public static class UpdateUserOK extends RootResponse.OK<User> {
        public UpdateUserOK(User data) {
            super(data);
        }

        @Schema(example="UpdateUserOK")
        private String label = "UpdateUserOK";

        @Schema(example="사용자 정보를 수정했습니다")
        private String message = "사용자 정보를 수정했습니다";
    }

    @Schema(description="사용자 정보 수정 실패 응답")
    public static class UpdateUserFail extends RootResponse.BadRequest {
        @Schema(example="UpdateUserFail")
        private String label = "UpdateUserFail";

        @Schema(example="사용자 정보 수정에 실패했습니다")
        private String message = "사용자 정보 수정에 실패했습니다";
    }


    /* DeleteUser */
    @Schema(description="사용자 삭제 성공 응답")
    public static class DeleteUserOK extends RootResponse.OK<Void> {
        public DeleteUserOK() {
            super(null);
        }

        @Schema(example="DeleteUserOK")
        private String label = "DeleteUserOK";

        @Schema(example="사용자를 삭제했습니다")
        private String message = "사용자를 삭제했습니다";
    }

    @Schema(description="사용자 삭제 실패 응답")
    public static class DeleteUserFail extends RootResponse.BadRequest {
        @Schema(example="DeleteUserFail")
        private String label = "DeleteUserFail";

        @Schema(example="사용자 삭제에 실패했습니다")
        private String message = "사용자 삭제에 실패했습니다";
    }


    /* SearchUsers */
    @Schema(description="사용자 검색 성공 응답")
    public static class SearchUsersOK extends RootResponse.OK<List<User>> {        
        public SearchUsersOK(List<User> data) {
            super(data);
        }

        @Schema(example="SearchUsersOK")
        private String label = "SearchUsersOK";

        @Schema(example="사용자 검색을 완료했습니다")
        private String message = "사용자 검색을 완료했습니다";

        @Schema(description="사용자 목록", example="TODO흠흐밍")
        private List<User> data = new ArrayList<>();
    }
}
