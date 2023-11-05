package lotto.utils;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    NULL_INPUT("입력이 null입니다."),
    EMPTY_INPUT("입력이 공백으로만 이루어져 있습니다."),
    NOT_INTEGER_INPUT("입력이 정수가 아닙니다."),
    CHANGE_REMAINED("구입 금액이 로또 가격으로 나누어 떨어지지 않아 잔돈이 발생합니다."),
    NO_MONEY("구입 금액은 0보다 작거나 같을 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 %d~%d사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBERS_LENGTH("로또는 총 %d개의 번호로 이루어져야 합니다."),
    LOTTO_NUMBER_DUPLICATION("로또 번호에 중복이 있습니다."),
    WINNING_NUMBERS_CONTAINS_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    private String get() {
        return message;
    }

    public String getWithPrefix() {
        return PREFIX.get() + message;
    }

    public String getWithFormatAndPrefix(int number) {
        return PREFIX.get() + String.format(message, number);
    }
    public String getWithFormatAndPrefix(int minNumber, int maxNumber) {
        return PREFIX.get() + String.format(message, minNumber, maxNumber);
    }
}
