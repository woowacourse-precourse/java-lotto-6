package lotto.exception;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    OUT_OF_SIZE("[ERROR] 개수가 맞지 않습니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복되지 않는 숫자여야 합니다."),
    NOT_THOUSAND_PRICE("[ERROR] 로또 1장의 가격은 1,000원입니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
