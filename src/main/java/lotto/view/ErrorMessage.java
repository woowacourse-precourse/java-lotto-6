package lotto.view;

public enum ErrorMessage {
    INVALID_PURCHASE_PAYMENT("로또 구입 금액으로 1,000 배수를 공백 없이 입력 해 주세요"),
    ;


    private final String message;

    ErrorMessage(String message){
        String prefix = "[ERROR] ";
        this.message = prefix + message;
    }

    public String getMessage(){
        return message;
    }
}
