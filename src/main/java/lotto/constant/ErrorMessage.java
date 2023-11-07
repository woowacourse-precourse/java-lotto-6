package lotto.constant;

public enum ErrorMessage {
    NON_EXIST_INPUT("[ERROR] 값이 입력되지 않았습니다."),
    NOT_DIGIT("[ERROR] 숫자가 아닌 값이 입력되었습니다."),
    EXIST_ZERO("[ERROR] 0이 입력되었습니다."),
    INVALID_MONEY("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NON_EXIST_COMMA("[ERROR] 콤마(,)로 구분된 여섯개의 숫자를 입력해야 합니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_SIZE("[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다."),
    EXIST_DUPLICATE("[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    EXIST_BONUS("[ERROR] 이미 있는 숫자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
