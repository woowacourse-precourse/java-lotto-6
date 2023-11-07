package lotto;

public enum ErrorMessages {
    NO_CONTENT("[ERROR] 공백은 유효하지 않은 입력입니다."),
    NOT_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다."),
    NOT_MATCHED_DIGITS_FOR_NUMBERS("[ERROR] 로또 번호는 6자리를 입력해야 합니다."),
    NOT_MATCHED_DIGITS_FOR_BONUS_NUMBER("[ERROR] 보너스 번호는 1자리를 입력해야 합니다."),
    NOT_ALLOW_REMAINDER("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    TOO_LOW_BUDGET("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다."),
    NOT_ALLOW_OVERLAP("중복된 숫자가 있습니다.");


    private final String message;

    ErrorMessages (String message) {
        this.message = message;
    }

    public String value() {
        return this.message;
    }
}
