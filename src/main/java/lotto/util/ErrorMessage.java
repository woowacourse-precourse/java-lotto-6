package lotto.util;

public enum ErrorMessage {

    IS_EMPTY("값을 입력해 주세요."),
    IS_NOT_NUMBER("투입 금액은 숫자여야 합니다."),
    IS_NOT_DIVIDED_BY_PRICE("로또 금액 단위로 금액을 투입해 주세요!"),
    IS_NOT_POSITIVE_NUMBER("투입 금액은 음수가 될 수 없습니다."),
    IS_NOT_OVER_MIN_PRICE("로또를 구매할 돈이 부족합니다.")
    ;

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_MESSAGE + message;
    }
}