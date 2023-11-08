package constant;

import java.util.Arrays;

public enum ErrorMessage {
    ERROR(900, "[ERROR]"),
    NOT_NUMBER(901, "숫자만 입력이 가능합니다.\n"),
    INVALID_TICKET_PRICE(902, "1000원 단위의 숫자만 입력해주세요.\n"),
    DUPLICATED_NUMBER(903, "중복된 숫자가 존재합니다."),
    INVALID_BOUNDS(904, "1이상 45이하의 숫자만 입력가능합니다."),
    INVALID_WINNING_COUNT(905, "당첨 번호는 6개를 입력해야 합니다."),
    INVALID_WINNING_INPUT(906, "당첨 번호는 숫자와 쉼표만 입력가능합니다."),
    INVALID_BONUS_COUNT(907, "보너스 번호는 1개만 입력해야 합니다."),
    DUPLICATED_BONUS_NUMBER(908, "보너스 번호는 당첨 번호와 달라야 합니다.");
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
