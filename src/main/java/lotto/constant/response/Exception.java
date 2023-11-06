package lotto.constant.response;

public enum Exception {
    MONEY_NULL_BLANK("[ERROR] 로또 구입 금액을 입력해야 합니다."),
    MONEY_NUMERIC("[ERROR] 로또 구입 금액은 숫자로 이루어져야 합니다.");
    private String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
