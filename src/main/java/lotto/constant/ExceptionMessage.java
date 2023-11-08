package lotto.constant;

public enum ExceptionMessage {
    INPUT_SIX_NUMBER("6개의 수를 입력해야 합니다"),
    INPUT_CORRECT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBERS("서로 중복되지않는 수를 입력해야 합니다"),
    INPUT_NUMBER("숫자를 입력해야 합니다"),
    DUPLICATE_NUMBERS_LOTTO("보너스 번호는 로또 번호와 중복되지 않아야 합니다"),
    INVALID_COMMA_USAGE("콤마를 올바르게 찍어야합니다"),
    LOTTO_INPUT_AMOUNT_INCREMENT("1000원 단위로 입력해야 합니다"),
    INPUT_NOT_ZERO("입력금액은 0원 보다 커야합니다"),
    PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK("숫자 사이에 공백을 입력하지 마세요"),
    INVALID_AMOUNT_MESSAGE("1부터 45 사이의 숫자여야 합니다."),
    INVALID_AMOUNT_PRICE_MESSAGE("너무 크거나 작은수를 입력했습니다(9,223,372,036,854,775,807이하의 1000단위를 입력하세요)");

    private static final String FIRST_MESSAGE = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = FIRST_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
