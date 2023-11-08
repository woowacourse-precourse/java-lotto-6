package lotto.enums;

public enum OutputMessage {
    LOTTO_NUMBERS("%s"),
    NUMBER_OF_PURCHASED_LOTTO("%d개를 구매했습니다."),
    RESULT_OF_LOTTERY(""
            + "당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (5,000원) - %d개\n"
            + "5개 일치 (5,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (5,000원) - %d개\n"
            + "6개 일치 (5,000원) - %d개"
    ),
    RETURN_RATE("총 수익률은 %.1f%%입니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
