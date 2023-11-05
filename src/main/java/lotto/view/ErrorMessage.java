package lotto.view;

public enum ErrorMessage {
    WRONG_TYPE("[ERROR] 올바르지 않은 입력입니다.(정수값을 입력하세요)"),
    WRONG_AMOUNT("[ERROR] 올바르지 않은 입력입니다.(1000의 배수를 입력하세요)"),
    WRONG_RANGE("[ERROR] 올바르지 않은 입력입니다.(1~45사이의 수를 입력하세요)"),
    WRONG_LENGTH("[ERROR] 올바르지 않은 입력입니다.(6자리의 수를 입력하세요)"),
    DUPLICATION("[ERROR] 올바르지 않은 입력입니다.(중복된 숫자가 존재합니다)");

    private final String errorMessage;

    ErrorMessage(String message) {
        this.errorMessage = message;
    }
    
    public String getMessage() {
        return errorMessage;
    }
}
