package lotto.validator;

public enum Errors {

    NOT_INTEGER("[ERROR] 정수 타입이 아닙니다."),
    NULL("[ERROR] 값을 입력해야합니다."),
    AMOUNT_NOT_DIVIDED("[ERROR] 금액이 나누어 떨어지지 않습니다.");

    private final String message;

    Errors(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
