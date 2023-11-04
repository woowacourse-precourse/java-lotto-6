package lotto.constraints;

public enum ErrorMessage {

    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 존재합니다."),
    INVALID_MONEY("[ERROR] 1000원 이상의 금액을 입력해주세요."),
    NOT_MULTIPLE_PER_PRICE("[ERROR] 1000원 단위로 입력해주세요."),
    OUT_OF_RANGE("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");


    public String getMessage() {
        return message;
    }

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
