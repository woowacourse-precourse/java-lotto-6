package lotto.view.message.exception;

public enum BudgetInputErrorMessage {
    LESS_THAN_1000("[ERROR] 1000원 이상부터 구매가 가능합니다."),
    NOT_NUMBER("[ERROR] 금액은 숫자만 입력 가능합니다."),
    DIVISIBLE_BY_THOUSAND("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;
    BudgetInputErrorMessage(String message) {
        this.message= message;
    }

    public String getMessage(){
        return message;
    }

    public void displayMessage(){
        System.out.println(message);
    }

    
}
