package lotto.message;

public enum ErrorMessage {

    ERROR_NOT_NUMBER("[ERROR] 정수가 아닌 입력입니다."),
    ERROR_NOT_NATURAL_NUM("[ERROR] 자연수가 아닌 입력입니다."),
    ERROR_NOT_THOUSANDS_UNIT("[ERROR] 1000원 단위가 아닌 입력입니다."),
    ERROR_OUT_RANGE("[ERROR] 1과 45사이의 숫자가 아닌 입력입니다."),
    ERROR_DUPLICATE("[ERROR] 중복되는 숫자가 있습니다."),
    ERROR_NOT_6NUMBERS("[ERROR] 6개의 숫자가 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return this.errorMessage;
    }


}
