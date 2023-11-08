package lotto.util;

public enum Message {
    GET_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    GET_LOTTO_NUMBER("\n당첨 번호를 입력해 주세요."),
    GET_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해주세요"),
    TEXT_RESULT("\n당첨 통계\n---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
