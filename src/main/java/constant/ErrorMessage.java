package constant;

import java.util.Arrays;

public enum ErrorMessage {
    ERROR(900, "[ERROR]"),
    NOT_NUMBER(901, "숫자만 입력이 가능합니다.\n"),
    INVALID_TICKET_PRICE(902, "1000원 단위의 숫자만 입력해주세요.\n"),
    DUPLICATED_NUMBER(903, "중복된 숫자가 존재합니다.");
    private final int code;
    private final String message;
    private ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int getCode() {
        return code;
    }

    private String getMessage() {
        return message;
    }

    private static String getMessageByCode(final int code) {
        return Arrays.stream(ErrorMessage.values())
                .filter(errorMessage -> errorMessage.getCode() == code)
                .findFirst().map(ErrorMessage::getMessage).orElse("해당 에러코드는 존재하지 않습니다.");
    }

    public static String buildErrorMessage(final int code) {
        return ERROR.message +String.join(" ", getMessageByCode(code));
    }
}
