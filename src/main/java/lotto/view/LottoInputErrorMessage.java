package lotto.view;

public enum LottoInputErrorMessage {

    BONUS_NUMBER_NOT_IN_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요."),
    INVALID_LOTTO_NUMBER_FORMAT("[ERROR] 로또 숫자가 올바르지 않습니다. 다시 입력해 주세요."),
    INVALID_PAYMENT("[ERROR] 로또 구매 금액이 올바르지 않습니다. 다시 입력해 주세요.");

    private final String message;

    LottoInputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
