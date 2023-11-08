package lotto.global.constant.message;

public enum LottoMessage {

    INPUT_MONEY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RANDOM_PURCHASE_RESULT("\n%d개를 구매했습니다.\n"),
    RESULT_STATISTICS("\n당첨 통계\n---\n"),
    PROFIT_PERCENTAGE("총 수익률은 %.1f%%입니다."),
    ;

    LottoMessage(String text) {
        this.text = text;
    }

    private final String text;


    public String getText() {
        return text;
    }
}
