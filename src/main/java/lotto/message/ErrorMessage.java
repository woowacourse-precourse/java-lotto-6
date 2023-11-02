package lotto.message;

public enum ErrorMessage {

    NUMBER_OUT_OF_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_UNITS_OF_THOUSAND_ERROR("[ERROR] 돈이 천원 단위가 아닙니다."),
    DUPLICATED_NUMBERS_ERROR("[ERROR] 숫자가 중복 되었습니다"),
    ENTER_MORE_NUMBERS_ERROR("[ERROR] 숫자가 더 많이 입력되었습니다. 6개까지 입력가능합니다"),
    ENTER_MORE_BONUS_NUMBER_ERROR("[ERROR] 보너스 숫자는 1개만 입력이 가능합니다");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
