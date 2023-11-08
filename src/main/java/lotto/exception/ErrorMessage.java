package lotto.exception;

public enum ErrorMessage {

    // Lotto
    EMPTY("빈 값은 입력할 수 없습니다."),
    MISMATCH_LOTTO_NUMBER("6개의 로또 번호를 입력해야 합니다."),
    DUPLICATED_LOTTO_NUMBER("중복된 로또 번호를 입력했습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    // LottoMachine
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 단위로 입력해야 합니다."),

    // Input
    NOT_NUMBER("숫자가 아닌 값을 입력할 수 없습니다.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
