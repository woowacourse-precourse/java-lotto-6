package lotto.configurations;

public enum ErrorMessages {
    ERROR_HEADER("[ERROR] "),
    INVALID_SIZE_MESSAGE("숫자는 6개"),
    OUT_OF_RANGE_NUMBER_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONLY_INTEGER_MESSAGE("숫자만 입력하세요"),
    INVALID_UNIT_MESSAGE("1000원 단위로 입력해주세요"),
    NO_SPACE_MESSAGE("공백없이 입력하세요"),
    ALREADY_DRAWN_MESSAGE("중복 추첨된 번호입니다."),
    OUT_OF_RANGE_PURCHASE_MESSAGE("허용 범위를 벗어난 구매 금액입니다."),
    INPUT_SEPARATOR_MESSAGE("를 사용하여 구분해주세요");

    private final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return errorMessage;
    }
}
