package lotto.constant.response;

public enum Exception {
    MONEY_NULL_BLANK("[ERROR] 로또 구입 금액을 입력해야 합니다."),
    MONEY_NUMERIC("[ERROR] 로또 구입 금액은 숫자로만 이루어져야 합니다."),
    WINNING_NUMBERS_NULL_BLANK("[ERROR] 당첨 번호를 입력해야 합니다."),
    WINNING_NUMBERS_NUMERIC("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
