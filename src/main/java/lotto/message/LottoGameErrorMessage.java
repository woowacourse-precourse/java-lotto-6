package lotto.message;

public enum LottoGameErrorMessage {
    NOT_ABLE_TO_PARSE_INT_MESSAGE("숫자를 입력해주세요"),
    UNDER_ZERO_MESSAGE("0을 초과한 수를 입력해주세요"),
    BASE_UNIT_INPUT_MESSAGE("1000원 단위로 입력해주세요"),
    SIZE_IS_NOT_EXACT("6개의 수를 입력해주세요"),
    NUMBERS_ARE_DUPLICATED("중복된 수가 없도록 입력해주세요"),
    NUMBERS_NOT_IN_RANGE("1 ~ 45까지의 수를 입력해주세요"),
    ;

    private static final String ERROR_PREFIX = "[ERROR]";
    private final String message;

    LottoGameErrorMessage(String message) {
        this.message = ERROR_PREFIX + " " + message;
    }

    public String getMessage() {
        return this.message;
    }
}
