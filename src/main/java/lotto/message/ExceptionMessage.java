package lotto.message;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자를 입력해주세요."),
    NOT_THOUSAND("[ERROR] 1,000원 단위로 입력해주세요"),
    NOT_6_NUMBER("[ERROR] 6개의 숫자를 입력해주세요"),
    NOT_RANGE_NUMBER("[ERROR] 1이상 45이하의 숫자를 입력해주세요"),
    INCORRECT_FORM("[ERROR] \' , \' 기준으로 입력해주세요"),
    DUPLICATE_NUMBER("[ERROR] 중복되지 않는 숫자를 입력해주세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
