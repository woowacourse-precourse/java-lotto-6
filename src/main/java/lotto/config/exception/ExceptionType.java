package lotto.config.exception;

public enum ExceptionType {

    ERROR_LOTTO_INPUT_SIX("[ERROR] 숫자는 6개만 입력가능합니다."),
    ERROR_LOTTO_DUPLICATE("[ERROR] 숫자는 중복될 수 없습니다."),
    ERROR_TICKETS_GENERATE("[ERROR] 발행을 위한 금액은 1,000단위입니다."),
    ERROR_CONVERT_TO_INT_ONLY_NUMBER("[ERROR] 오직 숫자만 입력할 수 있습니다."),
    ERROR_CONVERT_TO_LIST_WHITESPACE("[ERROR] 입력값에 공백이 있습니다."),
    ERROR_LOTTO_RANGE("[ERROR] 입력하신 숫자는 로또 범위안에 없습니다.");

    private final String value;

    ExceptionType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
