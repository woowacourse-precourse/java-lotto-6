package lotto.excpetion.constant;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    OUT_OF_SIZE("[ERROR] 알맞는 개수를 입력해야 합니다."),
    NOT_IN_RANGE("[ERROR] 1~45 안의 숫자를 입력해야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복되지 않도록 입력해야 합니다."),
    NOT_THOUSAND_PRICE("[ERROR] 1000단위로 입력해야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
