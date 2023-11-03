package lotto.view;

public enum LottoErrorMessage {

    BONUS_NUMBER_NOT_IN_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요."),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] 로또 숫자는 6개만 입력이 가능합니다. 다시 입력해 주세요.")
    ;

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
