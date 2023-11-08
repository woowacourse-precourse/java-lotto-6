package lotto.domain.view;

public enum OutputViewFormat {
    GUIDE_LOTTO_AMOUNT_FORMAT("%d개를 구매했습니다."),
    GUIDE_RESULT_FORMAT("%s - %d개"),
    GUIDE_RATE_FORMAT("총 수익률은 %.1f%%입니다."),
    GUIDE_STATICS("당첨 통계\n---");

    final String state;

    OutputViewFormat(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
