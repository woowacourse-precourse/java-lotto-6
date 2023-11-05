package lotto.service.exception;

public enum InputErrorMessage {

    WRONG_INPUT_MONEY_UNIT("[ERROR] 1,000원 단위로 입력해야 합니다."),

    OVER_RANGE_MONEY("[ERROR] 50,000원 보다는 작게 입력해야 합니다."),

    INVALID_NUMBER("[ERROR] 모두 숫자로 입력해야 합니다.");

    private final String ErrorMessage;

    InputErrorMessage(String message) {
        this.ErrorMessage = message;
    }

    public String getMessage(){
        return ErrorMessage;
    }
}
