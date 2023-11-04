package lotto.global;

public enum LottoInputMessage {

    LOTTO_PURCHASE_AMOUNT("구매 금액을 입력해 주세요."),
    LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    LottoInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
