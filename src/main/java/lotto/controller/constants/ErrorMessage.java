package lotto.controller.constants;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 입력값이 숫자가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 입금액은 1,000원 단위로 입력되어야 합니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}