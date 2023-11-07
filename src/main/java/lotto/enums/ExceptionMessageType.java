package lotto.enums;

public enum ExceptionMessageType {
    NUMBER_NOT_INTEGER("문자를 제외한 정수만 입력 가능합니다."),
    PAYMENT_NOT_NATURAL_NUMBER("구입 금액은 0원보다 커야 합니다."),
    PAYMENT_OUT_OF_INTEGER_RANGE("구입 금액은 21474836470 이하 숫자만 가능합니다."),
    PAYMENT_INVALID_UNIT("구입 금액은 1,000원 단위만 가능합니다."),
    INVALID_SEPARATOR_OR_NUMBER_COUNT("6개의 숫자를 쉼표(,)로 구분하여 입력하세요."),
    NUMBER_OUT_OF_RANGE("번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_WINNING_NUMBERS("당첨 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("당첨 번호와 중복되지 않은 번호를 입력하세요.");

    private final String message;

    ExceptionMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}