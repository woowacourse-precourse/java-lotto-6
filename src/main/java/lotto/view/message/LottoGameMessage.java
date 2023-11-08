package lotto.view.message;

public enum LottoGameMessage {
    BUY_LOTTO_MONEY("구입금액을 입력해 주세요."),
    LOTTOS_AMOUNT("개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PROFIT_RATE("총 수익률은 "),
    PERCENT("%입니다."),
    COUNT("개"),
    DASH(" - ");

    public final String message;

    LottoGameMessage(final String message) {
        this.message = message;
    }
}
