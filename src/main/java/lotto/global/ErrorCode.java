package lotto.global;

public enum ErrorCode {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호가 범위를 벗어났습니다."),
    LOTTO_NUMBER_COUNT_INCORRECT("로또 번호의 개수가 다릅니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호가 중복되었습니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
