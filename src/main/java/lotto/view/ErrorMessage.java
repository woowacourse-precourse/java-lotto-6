package lotto.view;

public enum ErrorMessage {
    WRONG_TYPE("[ERROR] 정수가 아닌 수가 포함되어 있습니다."),
    WRONG_AMOUNT("[ERROR] 구입금액은 1000의 배수여야 합니다."),
    WRONG_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_LENGTH("[ERROR] 로또 번호는 6자리여야 합니다."),
    DUPLICATION("[ERROR] 중복된 숫자가 존재합니다.");

    private final String errorMessage;

    ErrorMessage(String message) {
        this.errorMessage = message;
    }
    
    public String getMessage() {
        return errorMessage;
    }
}
