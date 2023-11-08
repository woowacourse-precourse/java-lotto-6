package lotto.model.domain.constants;

public enum LottoGameMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계\n---"),
    MATCH_COUNT("%d개 일치 (%,d원) - %d개"),
    MATCH_BONUS_COUNT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
