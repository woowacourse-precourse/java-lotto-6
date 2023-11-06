package lotto;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    INDIVISIBLE_NUMBER("나누어 떨어지지 않는 금액 단위입니다."),
    ZERO_NUMBER("0원이 입력 됐습니다."),
    NOT_NUMBER_FORMAT("숫자가 아닌 돈이 입력 됐습니다."),
    OVER_LOTTO_SIZE("로또 번호의 개수가 6개가 넘어갔습니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호가 중복 됐습니다."),
    OVER_LOTTO_BOUNDARY("범위 밖의 로또 번호가 포함되었습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
