package lotto.utils.message;

public enum InputExceptionMessage {
    BLANK("[ERROR] 공백 입력은 안됩니다."),
    FIRST_CHARACTER_COMMA("[ERROR] 콤마(,)는 첫 문자로 올 수 없습니다."),
    LAST_CHARACTER_COMMA("[ERROR] 콤마(,)는 마지막 문자로 올 수 없습니다."),
    NOT_NUMERIC("[ERROR] 숫자로만 입력해야 합니다."),
    EXCEED_WINNING_NUMBER_LENGTH("[ERROR] 당첨 번호는 20 자리 이내로 입력해야 합니다."),
    EXCEED_BONUS_NUMBER_LENGTH("[ERROR] 보너스 번호는 2 자리 이내로 입력해야 합니다."),
    EXCEED_PURCHASE_AMOUNT_LENGTH("[ERROR] 구입 금액은 9 자리 이내로 입력해야 합니다.");

    private final String error;

    InputExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
