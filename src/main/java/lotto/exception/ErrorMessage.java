package lotto.exception;

public enum ErrorMessage {
    NOT_INTEGER_ERROR_MESSAGE("[ERROR] 숫자를 입력해 주세요."),
    OUT_RANGE_ERROR_MESSAGE("[ERROR] 범위를 벗어난 숫자 입니다."),
    NULL_INPUT_ERROR_MESSAGE("[ERROR] 입력값을 확인해 주세요."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 중복 숫자가 존재합니다"),
    HAVE_CHANGE_ERROR_MESSAGE("[ERROR] 1000원 단위로 입력해 주세요."),
    LENGTH_ERROR_MESSAGE("[ERROR] 로또 숫자의 갯수를 확인하세요.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
