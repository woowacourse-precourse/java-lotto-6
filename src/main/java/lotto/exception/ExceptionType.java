package lotto.exception;

public enum ExceptionType {

    ERROR_LOTTO_INPUT_SIX("[ERROR] 숫자는 6개만 입력가능합니다."),
    ERROR_LOTTO_DUPLICATE("[ERROR] 숫자는 중복될 수 없습니다."),
    ERROR_LOTTO_TICKET_GENERATE("[ERROR] 발행을 위한 금액은 1,000단위입니다.");

    private final String value;

    ExceptionType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
