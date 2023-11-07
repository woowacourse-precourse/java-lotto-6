package lotto.view;

public enum ExceptionMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구매 금액은 1,000원 단위여야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_INPUT_NUMBER("[ERROR] 다시 입력해 주세요."),
    INVALID_NUMBER_RANGE("[ERROR] 1~45 범위의 숫자를 입력해 주세요."),
    INVALID_NUMBER_EMPTY("[ERROR] 아무것도 입력하지 않으셨습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 중복된 숫자를 입력하셨습니다."),;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
