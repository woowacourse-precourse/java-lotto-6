package lotto.enums;

public enum ErrorMessage {
    FORMAT("[ERROR] %s"),
    NUMBER_OF_LOTTO_NUMBERS_IS_6("6개의 로또 번호가 필요합니다."),
    LOTTO_NUMBERS_HAS_NO_DUPLICATE("로또 번호는 중복이 될 수 없습니다."),
    LOTTO_NUMBERS_HAS_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    STRING_CANNOT_CONVERT_TO_INTEGER("문자가 포함된 문자열은 정수로 변환될 수 없습니다."),
    STRING_CANNOT_CONVERT_TO_FLOAT("문자가 포함된 문자열은 실수로 변환될 수 없습니다."),
    MONEY_MUST_POSITIVE_NUMBER_AND_1000_UNITS("구입 금액은 1000 단위의 양수 또는 0입니다."),
    ILLEGAL_COUNT_OF_NUMBER_MATCHES("올바르지 않은 일치 개수입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String errorFormat = FORMAT.getFormat();

        return String.format(errorFormat, message);
    }

    private String getFormat() {
        return message;
    }
}
