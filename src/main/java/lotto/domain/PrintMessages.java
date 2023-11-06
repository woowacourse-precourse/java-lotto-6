package lotto.domain;

public enum PrintMessages {
    PURCHASED_LOTTOS_COUNT("개를 구매했습니다."),
    ERROR_PREFIX("[ERROR] "),
    WINNING_STATISTICS_ANNOUNCE("당첨 내역을 출력합니다."),
    MATCH_3("3개 일치 (5,000원),"),
    MATCH_4("4개 일치 (50,000원),"),
    MATCH_5("5개 일치 (1,500,000원),"),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원),"),
    MATCH_6("6개 일치 (2,000,000,000원),"),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    TOTAL_EARNINGS_RATE("총 수익률은 %.2f%%입니다.\n");

    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedEarningRate(double earningRate) {
        return String.format(message, earningRate);
    }
}