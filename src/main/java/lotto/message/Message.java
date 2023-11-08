package lotto.message;

public enum Message {
    INPUT_BUY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LOTTERY_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_LOTTERY_RESULT(
            "당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n"),
    PRINT_PROFIT_RATE("총 수익률은 %.1f%%입니다.\n"),
    PRINT_BOUGHT_LOTTO_AMOUNT("%d개를 구매했습니다.\n"),
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
