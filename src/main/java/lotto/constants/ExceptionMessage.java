package lotto.constants;

public enum ExceptionMessage {
    BE_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    HAS_LETTER("[ERROR] 문자를 포함할 수 없습니다."),
    IS_DUPLICATED("[ERROR] 중복된 숫자를 포함할 수 없습니다."),
    IS_DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다."),
    IS_INSUFFICIENT("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다."),
    IS_NOT_THOUSAND_UNIT("[ERROR] 입력하신 금액은 천원 단위가 아닙니다."),
    IS_UNDER_MIN_LIMIT("[ERROR] 최소 구매 금액은 1000원 입니다."),
    IS_EXCESS_MAX_LIMIT("[ERROR] 개인당 구매 가능 한도는 100,000원 입니다. ");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
