package lotto;

public enum ErrorCode {

    // input
    CONTAIN_NON_NUMERIC_CHARACTER("[ERROR] 숫자만 입력하세요."),
    NOT_CONTAIN_NUMERIC_CHARACTER("[ERROR] 입력값에 숫자가 존재하지 않습니다."),

    // lotto
    NOT_ENOUGH_NUMBERS("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다."),
    INCORRECT_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),

    // lottos
    NOT_DIVIDED_BY_UNIT_PRICE("[ERROR] 구입 금액은 1000원 단위입니다.");

    

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
