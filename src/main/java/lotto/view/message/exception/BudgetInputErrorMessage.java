package lotto.view.message.exception;

public enum BudgetInputErrorMessage {
    LESS_THAN_1000("[ERROR] 1000원 이상부터 구매가 가능합니다."),
    NOT_NUMBER("[ERROR] 금액 필드에는 숫자만 입력 가능합니다.");

    private final String message;
    BudgetInputErrorMessage(String message) {
        this.message= message;
    }

    public String getMessage(){
        return message;
    }
}
