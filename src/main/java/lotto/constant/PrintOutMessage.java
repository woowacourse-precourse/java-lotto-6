package lotto.constant;

public enum PrintOutMessage {
    PLZ_INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("개를 구매했습니다."),
    PLZ_INPUT_WINNER_NUMBER("당첨 번호를 입력해 주세요."),
    PLZ_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_WINNING_STATISTICS("당첨 통계\n" + "---"),
    COUNT_SUFFIX("개"),
    PRINT_EARNING_PERCENT("총 수익률은 ");

    public final String message;

    PrintOutMessage(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
