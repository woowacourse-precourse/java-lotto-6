package lotto.global.error;

public enum ErrorMessage {

    INPUT_IS_INVALID("입력한 값이 올바르지 않습니다 (NULL 또는 공백)."),
    INPUT_IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    INPUT_OVER_MAX_LEN("입력한 숫자의 개수가 당첨 로또 최대 길이를 넘었습니다."),

    INVALID_LOTTO_NUMBER("입력한 숫자가 로또 번호 범위를 벗어납니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    };

    public String getMessage() {
        return message;
    }
}
