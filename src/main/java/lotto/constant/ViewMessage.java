package lotto.constant;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    PURCHASE_LOTTO_COUNT("개를 구매했습니다."),
    RESULT_LOTTO("\n당첨 통계\n---"),

    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String text;

    ViewMessage(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
