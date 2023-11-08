package lotto.global.error;

public enum ErrorMessage {

    INPUT_IS_INVALID("[ERROR] 입력한 값이 올바르지 않습니다 (NULL 또는 공백)."),
    INPUT_IS_NOT_NUMBER("[ERROR] 입력한 값이 숫자가 아닙니다."),
    INPUT_OVER_MAX_LEN("[ERROR] 입력한 숫자의 개수가 당첨 로또 최대 길이를 넘었습니다."),

    INVALID_LOTTO_NUMBER("[ERROR] 입력한 숫자가 로또 번호 범위를 벗어납니다."),
    INVALID_LOTTO_NUMBER_DUPLICATED("[ERROR] 입력한 로또 번호에 중복된 숫자가 존재합니다."),
    INVALID_LOTTO_PURCHASE_PRICE("[ERROR] 로또 구매 금액이 올바르지 않습니다."),

    INTERNAL_SERVER_ERROR("[ERROR] 서버 내에 예기치 못한 오류가 발생했습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    };

    public String getMessage() {
        return message;
    }
}
