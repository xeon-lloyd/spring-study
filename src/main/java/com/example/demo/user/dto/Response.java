package com.example.demo.user.dto;

import com.example.demo.dto.RootResponse;
import com.example.demo.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class Response {
    /* GetAllUsers */
    @Schema(description="사용자 목록 조회 성공 응답")
    public static class GetAllUsersOK extends RootResponse.OK<List<User>> {
        public GetAllUsersOK(List<User> data) {
            super(data);
            this.label = "GetAllUsersOK";
            this.message = "사용자 목록을 조회했습니다";
        }

        @Schema(example="GetAllUsersOK")
        public String getLabel() { return label; }

        @Schema(example="사용자 목록을 조회했습니다")
        public String getMessage() { return message; }
    }


    /* GetUserById */
    @Schema(description="사용자를 찾을 수 없음 응답")
    public static class UserNotFound extends RootResponse.NotFound {
        public UserNotFound() {
            super();
            this.label = "UserNotFound";
            this.message = "해당 사용자를 찾을 수 없습니다";
        }

        @Schema(example="UserNotFound")
        public String getLabel() { return label; }

        @Schema(example="해당 사용자를 찾을 수 없습니다")
        public String getMessage() { return message; }
    }

    @Schema(description="사용자 정보 조회 성공 응답")
    public static class GetUserByIdOK extends RootResponse.OK<User> {        
        public GetUserByIdOK(User data) {
            super(data);
            this.label = "GetUserByIdOK";
            this.message = "사용자 정보를 조회했습니다";
        }

        @Schema(example="GetUserByIdOK")
        public String getLabel() { return label; }
        
        @Schema(example="사용자 정보를 조회했습니다")
        public String getMessage() { return message; }
    }


    /* CreateUser */
    @Schema(description="사용자 생성 성공 응답")
    public static class CreateUserOK extends RootResponse.OK<User> {        
        public CreateUserOK(User data) {
            super(data);
            this.label = "CreateUserOK";
            this.message = "사용자를 생성했습니다";
        }

        @Schema(example="CreateUserOK")
        public String getLabel() { return label; }

        @Schema(example="사용자를 생성했습니다")
        public String getMessage() { return message; }
    }

    @Schema(description="사용자 생성 실패 응답")
    public static class CreateUserFail extends RootResponse.BadRequest {
        public CreateUserFail() {
            super();
            this.label = "CreateUserFail";
            this.message = "사용자 생성에 실패했습니다";
        }

        @Schema(example="CreateUserFail")
        public String getLabel() { return label; }

        @Schema(example="사용자 생성에 실패했습니다")
        public String getMessage() { return message; }
    }


    /* UpdateUser */
    @Schema(description="사용자 정보 수정 성공 응답")
    public static class UpdateUserOK extends RootResponse.OK<User> {
        public UpdateUserOK(User data) {
            super(data);
            this.label = "UpdateUserOK";
            this.message = "사용자 정보를 수정했습니다";
        }

        @Schema(example="UpdateUserOK")
        public String getLabel() { return label; }

        @Schema(example="사용자 정보를 수정했습니다")
        public String getMessage() { return message; }
    }

    @Schema(description="사용자 정보 수정 실패 응답")
    public static class UpdateUserFail extends RootResponse.BadRequest {
        public UpdateUserFail() {
            super();
            this.label = "UpdateUserFail";
            this.message = "사용자 정보 수정에 실패했습니다";
        }

        @Schema(example="UpdateUserFail")
        public String getLabel() { return label; }

        @Schema(example="사용자 정보 수정에 실패했습니다")
        public String getMessage() { return message; }
    }


    /* DeleteUser */
    @Schema(description="사용자 삭제 성공 응답")
    public static class DeleteUserOK extends RootResponse.OK<Void> {
        public DeleteUserOK() {
            super(null);
            this.label = "DeleteUserOK";
            this.message = "사용자를 삭제했습니다";
        }

        @Schema(example="DeleteUserOK")
        public String getLabel() { return label; }

        @Schema(example="사용자를 삭제했습니다")
        public String getMessage() { return message; }
    }

    @Schema(description="사용자 삭제 실패 응답")
    public static class DeleteUserFail extends RootResponse.BadRequest {
        public DeleteUserFail() {
            super();
            this.label = "DeleteUserFail";
            this.message = "사용자 삭제에 실패했습니다";
        }

        @Schema(example="DeleteUserFail")
        public String getLabel() { return label; }

        @Schema(example="사용자 삭제에 실패했습니다")
        public String getMessage() { return message; }
    }


    /* SearchUsers */
    @Schema(description="사용자 검색 성공 응답")
    public static class SearchUsersOK extends RootResponse.OK<List<User>> {        
        public SearchUsersOK(List<User> data) {
            super(data);
            this.label = "SearchUsersOK";
            this.message = "사용자 검색을 완료했습니다";
        }

        @Schema(example="SearchUsersOK")
        public String getLabel() { return label; }

        @Schema(example="사용자 검색을 완료했습니다")
        public String getMessage() { return message; }

        @Schema(description="사용자 목록", example="TODO흠흐밍")
        public List<User> getData() { return data; }
    }
}
