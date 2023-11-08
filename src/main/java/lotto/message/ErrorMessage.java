package lotto.message;

public enum ErrorMessage {
    NOT_WHOLE_NUMBER("[ERROR] 정수를 입력해주세요."),
    DUPLICATION_NUMBER("[ERROR] 중복된 번호입니다."),
    OUT_OF_RANGE("[ERROR] 1~45 사이의 정수만 입력해 주세요."),
    NOT_DIVIDED_BY_LOTTO_PRICE("[ERROR] 1000원 단위로 입력해주세요."),
    EXCEED_LOTTO_LENGTH("[ERROR] 로또 번호를 6개 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
