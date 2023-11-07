package lotto.view;

public enum ExceptionMessages {

    IS_NOT_NUMBER("[ERROR] 금액은 숫자만 입력 가능 합니다."),
    IS_NOT_DIVISIBLE("[ERROR] 로또 구매 금액은 1000원 단위로 입력되어야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
