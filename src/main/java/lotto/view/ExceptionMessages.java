package lotto.view;

public enum ExceptionMessages {

    ERROR_INPUT_AMOUNT("구입 금액은 숫자여야 합니다."),
    ERROR_INPUT_WINNING_LOTTO_NUMBER("당첨 번호는 숫자여야 합니다."),
    ERROR_INPUT_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    ERROR_INPUT_BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    ERROR_INPUT_LOTTO_NUMBER_DUPLICATE("당첨 번호는 중복되지 않아야 합니다."),
    ERROR_INPUT_LOTTO_NUMBER_RANGE("당첨 번호는 1 ~ 45 사이의 숫자여야 합니다."),
    ERROR_INPUT_BONUS_NUMBER_RANGE("보너스 번호는 1 ~ 45 사이의 숫자여야 합니다."),
    ERROR_INPUT_LOTTO_NUMBER_COUNT("당첨 번호는 6개여야 합니다."),
    ERROR_INPUT_BONUS_NUMBER_COUNT("보너스 번호는 1개여야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
