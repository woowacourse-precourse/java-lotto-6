package lotto.util;

public enum Message {
    REQUEST_MONEY("구입금액을 입력해 주세요."),
    RESULT_MONEY("%d개를 구입했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
