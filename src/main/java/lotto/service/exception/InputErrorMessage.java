package lotto.service.exception;

public enum InputErrorMessage {

    // 금액 입력 예외목록
    WRONG_INPUT_MONEY_UNIT("[ERROR] 1,000원 단위로 입력해야 합니다."),
    OVER_RANGE_MONEY("[ERROR] 50,000원 보다는 작게 입력해야 합니다."),
    INVALID_NUMBER("[ERROR] 모두 숫자로 입력해야 합니다."),


    // 당첨번호 입력 예외목록
    WRONG_NUMBER_SIZE("[ERROR] 숫자 6개를 입력해야 합니다."),
    WRONG_NUMBER_RANGE("[ERROR] 1~45 사이를 입력해야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 숫자가 중복되면 안됩니다.");

    private final String ErrorMessage;

    InputErrorMessage(String message) {
        this.ErrorMessage = message;
    }

    public String getMessage(){
        return ErrorMessage;
    }
}
