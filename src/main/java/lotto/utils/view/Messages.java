package lotto.utils.view;

public enum Messages {
    SETUP_BUY_PRICE_MESSAGE("\n구매금액을 입력해 주세요."),
    SETUP_BUY_LOTTO_MESSAGE("\n%d개를 구매했습니다."),
    SETUP_WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
