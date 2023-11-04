package lotto;

public enum ErrorException {
    WRONG_LOTTO_SIZE("6개의 숫자를 입력하지 않았습니다."),
    DUPLICATED_NUMBER("중복된 숫자를 입력했습니다."),
    OUT_OF_RANGE_NUMBER("범위에서 벗어난 수를 입력했습니다. 로또 번호 범위는 1~45까지입니다")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String errorDescription;

    ErrorException(String errorDescription) {
        this.errorDescription = PREFIX + errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
