package lotto.view;

public enum ErrorMessage {
    INVALID_PURCHASE_PAYMENT("로또 구입 금액으로 1,000 배수를 공백 없이 입력 해 주세요"),
    NOT_NUMBER("입력 내용이 숫자가 아닙니다."),
    INVALID_WINNING_LOTTO("로또는 6개 숫자로 이루어져 있어야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
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
