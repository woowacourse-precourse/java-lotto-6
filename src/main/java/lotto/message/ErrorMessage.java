package lotto.message;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해주세요."),
    NOT_THOUSAND("1,000원 단위로 입력해주세요"),
    NOT_6_NUMBER("6개의 숫자를 입력해주세요"),
    NOT_RANGE_NUMBER("1이상 45이하의 숫자를 입력해주세요"),
    INCORRECT_FORM(" \' , \' 기준으로 입력해주세요"),
    DUPLICATE_NUMBER("중복되지 않는 숫자를 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
