package lotto.view.constants;

public enum LottoMessage {
    INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTOS_COUNT("%d개를 구매했습니다."),
    LOTTO_NUMBERS("[%d, %d, %d, %d, %d, %d]"),
    INPUT_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... tokens) {
        return String.format(this.message, tokens);
    }
}
