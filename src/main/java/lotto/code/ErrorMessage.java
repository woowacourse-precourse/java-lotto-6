package lotto.code;


public enum ErrorMessage {
    EMPTY_DATA("[ERROR] 빈값 입력 불가입니다."),
    ONLY_NUMBERS("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_AMOUNT_UNIT_INPUT("[ERROR] 로또 구입 단위가 잘 못 되었습니다. 로또 1장 가격 : 1,000원"),
    INVALID_WINNER_NUMBERS_INPUT("[ERROR] 당첨 번호를 잘 못 입력하였습니다."),
    LOTTO_ONLY_SIX("[ERROR] 로또는 6개의 숫자여야 합니다."),
    LOTTO_DUPLICATION("[ERROR] 로또 숫자가 중복되었습니다."),
    LOTTO_INVALID_NUMBER_RANGE("[ERROR] 로또 숫자의 범위가 유효하지 않습니다. 범위 : 1 - 45"),

    ;

    private ErrorMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
