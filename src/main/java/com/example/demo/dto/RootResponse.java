package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;


public class RootResponse {
    // 기본 응답 틀
    @Schema(description="공통 응답 DTO")
    public static class BaseResponse<T> {        
        @Schema(description="응답 메시지")
        protected String message = "";

        @Schema(description="응답 데이터")
        protected T data = null;

        @Schema(description="HTTP 상태 코드")
        protected int status = 0;


        // Swagger가 필드를 인식하려면 반드시 getter 필요
        public String getMessage() { return message; }
        public T getData() { return data; }
        public int getStatus() { return status; }
    }


    // 기본 응답 클래스들
    @Schema(description="성공 응답 (200)")
    public static class OK<T> extends BaseResponse<T> {
        public OK(T data) {
            super();
            this.data = data;
        }

        @Schema(example="200")
        private int status = 200;

        @Schema(example="요청이 성공적으로 처리되었습니다")
        private String message = "요청이 성공적으로 처리되었습니다";

        @Schema(description="응답 데이터")
        private T data = null;
    }

    @Schema(description="잘못된 요청 응답 (400)")
    public static class BadRequest extends BaseResponse<Void> {
        public BadRequest() {
            super();
        }

        @Schema(example="400")
        private int status = 400;

        @Schema(example="잘못된 요청입니다")
        private String message = "잘못된 요청입니다";
    }

    @Schema(description="리소스를 찾을 수 없음 응답 (404)")
    public static class NotFound extends BaseResponse<Void> {
        public NotFound() {
            super();
        }

        @Schema(example="404")
        private int status = 404;

        @Schema(example="요청한 리소스를 찾을 수 없습니다")
        private String message = "요청한 리소스를 찾을 수 없습니다";
    }

    @Schema(description="서버 오류 응답 (500)")
    public static class ServerError extends BaseResponse<Void> {
        public ServerError() {
            super();
        }

        @Schema(example="500")
        private int status = 500;

        @Schema(example="서버 오류가 발생했습니다")
        private String message = "서버 오류가 발생했습니다";
    }
}
