package lotto.view;

public enum OutputMessage {
    PURCHASE_COUNT("%d개를 구매했습니다."),
    STATISTICS("당첨 통계\n---"),
    RANK("%d개 일치 (%s원) - %d개"),
    BONUS_RANK("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    YIELD("총 수익률은 %f%%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String get() {
        return outputMessage;
    }
}
