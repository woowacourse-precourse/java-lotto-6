package lotto.exception;

public enum ExceptionMessage {
    NOT_NUMBER("숫자를 입력하여주세요."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 %d부터 %d 사이의 숫자야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호의 개수는 %d개야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복이 없어야 합니다."),
    NOT_NATURAL_NUMBER("구입 금액은 자연수여야 합니다."),
    NOT_DIVIDE_UNIT("구입 금액은 %d 단위로 입력되어야 합니다."),
    DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER("당첨 번호의 값과 보너스 번호의 값 간의 중복이 없어야 합니다.");


    private static final String START = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return START + this.message;
    }

    public String get(int number) {
        return String.format(START + this.message, number);
    }

    public String get(int number1, int number2) {
        return String.format(START + this.message, number1, number2);
    }
}
