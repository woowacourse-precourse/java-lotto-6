package constant;

import java.util.Arrays;
import java.util.EnumMap;

public enum ServiceMessage {
    INPUT_BUY(101,"구입금액을 입력해 주세요.\n"),
    BUY_RESULT(102,"개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER(103,"당첨 번호를 입력해 주세요.\n"),
    INPUT_BONNUS_NUMBER(104,"보너스 번호를 입력해 주세요.\n"),
    FINAL_RESULT(105,"당첨 통계");
    private final int code;
    private final String message;
    private ServiceMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int getCode() {
        return code;
    }

    private String getMessage() {
        return message;
    }

    public static String getMessageByCode(int code) {
        return Arrays.stream(ServiceMessage.values())
                .filter(serviceMessage -> serviceMessage.getCode() == code)
                .findFirst().map(ServiceMessage::getMessage).orElse("해당 에러코드는 존재하지 않습니다.");
    }
}
