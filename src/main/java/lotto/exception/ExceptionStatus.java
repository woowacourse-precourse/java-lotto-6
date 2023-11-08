package lotto.exception;

public enum ExceptionStatus {
    MONEY_SHOULD_BE_MULTIPLE_OF_THOUSAND("금액은 1000의 배수여야 합니다."),
    INPUT_NUM_IS_WRONG("입력 개수가 맞지 않습니다."),
    INPUT_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private String message;
    private ExceptionStatus(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
