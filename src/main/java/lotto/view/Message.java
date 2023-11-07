package lotto.view;

public enum Message {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_BUY("%d개를 구매했습니다."),
    INPUT_WINNIG_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    OUTPUT_WIN_COUNT("당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n"),
    OUTPUT_STATISTICS("총 수익률은 %.2f%%입니다.");

    private final String msg;

    private Message(String msg) {
        this.msg = msg;
    }
    public String getValue() {
        return msg;
    }
}
