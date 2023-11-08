package lotto.type;

public enum ErrorMessageType {
    NOT_DIVIDE_THOUSAND("[Error] 1,000원 단위로만 입력 가능합니다."),
    OUT_OF_LOTTO_NUMERICAL_RANGE("[Error] 1과 45 사이의 값만을 입력해야 합니다."),
    NOT_POSITIVE_NUMBER("[Error] 음수나 0이 아닌 양수를 입력해야 합니다."),
    NOT_NUMBER("[Error] 숫자만을 입력해야 합니다."),
    DUPLICATE_NUMBER("[Error] 중복된 숫자를 입력하였습니다.");

    private String message;
    ErrorMessageType(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
