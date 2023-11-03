package lotto.utils;

public enum Message {
    PRINT_USER_INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    PRINT_USER_BUY_LOTTO_COUNT("개를 구매했습니다");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
