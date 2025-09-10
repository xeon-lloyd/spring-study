package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;


public class RootResponse {
    // 기본 응답 틀
    @Schema(description="공통 응답 DTO")
    public static class BaseResponse<T> {
        @Schema(description="HTTP 상태 코드")
        protected int status = 0;

        @Schema(description="응답 라벨")
        protected String label = "";

        @Schema(description="응답 메시지")
        protected String message = "";

        @Schema(description="응답 데이터")
        protected T data = null;


        // Swagger가 필드를 인식하려면 반드시 getter 필요
        public int getStatus() { return status; }
        public String getLabel() { return label; }
        public String getMessage() { return message; }
        public T getData() { return data; }
        
    }


    // 기본 응답 클래스들
    @Schema(description="성공 응답 (200)")
    public static class OK<T> extends BaseResponse<T> {
        public OK(T data) {
            super();
            this.status = 200;
            this.label = "OK";
            this.message = "요청이 성공적으로 처리되었습니다";
            this.data = data;
        }

        @Schema(example="200")
        public int getStatus() { return status; }

        @Schema(example="OK")
        public String getLabel() { return label; }

        @Schema(example="요청이 성공적으로 처리되었습니다")
        public String getMessage() { return message; }

        @Schema(description="응답 데이터")
        public T getData() { return data; }
    }

    @Schema(description="잘못된 요청 응답 (400)")
    public static class BadRequest extends BaseResponse<Void> {
        public BadRequest() {
            super();
            this.status = 400;
            this.label = "BadRequest";
            this.message = "잘못된 요청입니다";
        }

        @Schema(example="400")
        public int getStatus() { return status; }

        @Schema(example="BadRequest")
        public String getLabel() { return label; }

        @Schema(example="잘못된 요청입니다")
        public String getMessage() { return message; }
    }

    @Schema(description="인증 실패 응답 (401)")
    public static class Unauthorized extends BaseResponse<Void> {
        public Unauthorized() {
            super();
            this.status = 401;
            this.label = "Unauthorized";
            this.message = "인증 실패입니다";
        }

        @Schema(example="401")
        public int getStatus() { return status; }

        @Schema(example="Unauthorized")
        public String getLabel() { return label; }

        @Schema(example="인증 실패입니다")
        public String getMessage() { return message; }
    }

    @Schema(description="권한 없음 응답 (403)")
    public static class Forbidden extends BaseResponse<Void> {
        public Forbidden() {
            super();
            this.status = 403;
            this.label = "Forbidden";
            this.message = "권한 없음입니다";
        }
    
        @Schema(example="403")
        public int getStatus() { return status; }

        @Schema(example="Forbidden")
        public String getLabel() { return label; }

        @Schema(example="권한 없음입니다")
        public String getMessage() { return message; }
    }

    @Schema(description="리소스를 찾을 수 없음 응답 (404)")
    public static class NotFound extends BaseResponse<Void> {
        public NotFound() {
            super();
            this.status = 404;
            this.label = "NotFound";
            this.message = "요청한 리소스를 찾을 수 없습니다";
        }

        @Schema(example="404")
        public int getStatus() { return status; }

        @Schema(example="NotFound")
        public String getLabel() { return label; }

        @Schema(example="요청한 리소스를 찾을 수 없습니다")
        public String getMessage() { return message; }
    }

    @Schema(description="서버 오류 응답 (500)")
    public static class ServerError extends BaseResponse<Void> {
        public ServerError() {
            super();
            this.status = 500;
            this.label = "ServerError";
            this.message = "서버 오류가 발생했습니다";
        }

        @Schema(example="500")
        public int getStatus() { return status; }

        @Schema(example="ServerError")
        public String getLabel() { return label; }

        @Schema(example="서버 오류가 발생했습니다")
        public String getMessage() { return message; }
    }
}
