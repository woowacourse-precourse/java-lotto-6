package lotto.common;

public enum ErrorMessage {
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 6개만 가능합니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1~45만 가능합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되면 안됩니다."),


    /** 구입 금액 **/
    INVALID_INPUT_MONEY("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_MONEY_ZERO("[ERROR] 구입 금액은 0원보다 커야 합니다."),


    INVALID_NUMBER_FORMAT("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
