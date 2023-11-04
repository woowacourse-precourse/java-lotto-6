package lotto.constants;

public enum ErrorMessages {
    INPUT_MONEY_RANGE("구입 금액은 1000원 이상 이어야 합니다."),
    INPUT_MONEY_UNIT("구입 금액은 1000원 단위로 입력 해야 합니다."),
    INPUT_MONEY_NUMERIC("구입 금액은 숫자로 입력 해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return CommonLetter.ERROR_PREFIX.getLetter() + message;
    }
}
