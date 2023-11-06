package lotto.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    NOT_NUMERIC_INPUT("숫자를 입력해주세요."),
    WRONG_RANGE_INPUT("1,000원 이상의 구매 금액을 입력해주세요."),
    NOT_DIVISIBLE_INPUT("1,000원 단위의 구매 금액을 입력해주세요."),
    WRONG_AMOUNT_LOTTO_NUMBERS("로또 구매를 위한 6개의 당첨번호를 입력해주세요."),
    WRONG_RANGE_LOTTO_NUMBERS("번호는 1~45의 숫자를 입력해주세요."),
    WRONG_SEPARATOR_NUMBERS("구분자는 쉼표(,)를 사용해주세요.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessages;

    ExceptionMessages(String exceptionMessages) {
        this.exceptionMessages = ERROR_TAG + exceptionMessages;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessages);
    }
}
