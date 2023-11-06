package lotto.view;

public enum OutputViewMessage {
    WINNING_STATIC_MESSAGE("\n당첨 통계\n---"),
    PURCHASED_LOTTOS_MESSAGE_FORMAT("%d개를 구매했습니다."),
    SECOND_PLACE_RESULT_MESSAGE_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OTHER_PLACE_RESULT_MESSAGE_FORMAT("%d개 일치 (%s원) - %d개"),
    TOTAL_BENEFIT_MESSAGE_FORMAT("총 수익률은 %.1f%%입니다.");


    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
