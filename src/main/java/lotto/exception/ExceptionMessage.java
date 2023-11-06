package lotto.exception;

public enum ExceptionMessage {
    WRONG_LOTTO_SIZE("6개의 숫자를 입력하지 않았습니다."),
    DUPLICATED_NUMBER("중복된 숫자를 입력했습니다."),
    OUT_OF_RANGE_NUMBER("범위에서 벗어난 수를 입력했습니다. 로또 번호 범위는 1~45까지입니다"),
    NULL_INPUT("아무것도 입력하지 않았습니다."),
    NOT_MATCHES_NUMBER_PATTERN("숫자를 입력하지 않았습니다."),
    MULTIPLE_LETTERS_STARTS_WITH_ZERO("0으로 시작하는 수는 0만 가능합니다."),
    NOT_MATCHES_LOTTO_PATTERN("로또 번호는 (,) 로 구분해서 입력해야 합니다."),
    NOT_UNIT("1000 단위의 금액을 입력해주세요"),
    SAME_NUMBER_WITH_LOTTO_NUMBER("로또 번호와 중복된 보너스 번호입니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String errorDescription;

    ExceptionMessage(String errorDescription) {
        this.errorDescription = errorDescription;
    }



    public String getErrorDescription() {
        return PREFIX + errorDescription;
    }
}
