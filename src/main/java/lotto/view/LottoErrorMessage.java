package lotto.view;

public enum LottoErrorMessage {

    BONUS_NUMBER_NOT_IN_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요."),
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 숫자가 올바르지 않습니다. 다시 입력해 주세요."),
    INVALID_PAYMENT("[ERROR] 로또 구매 금액이 올바르지 않습니다. 다시 입력해 주세요."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 숫자 개수에 맞도록 다시 입력해 주세요."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 숫자 범위에 맞도록 다시 입력해 주세요."),
    INVALID_DUPLICATION("[ERROR] 로또 숫자는 중복될 수 없습니다. 다시 입력해 주세요."),
    INVALID_NEGATIVE_PAYMENT("[ERROR] 돈은 음수가 될 수 없습니다. 다시 입력해 주세요.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
