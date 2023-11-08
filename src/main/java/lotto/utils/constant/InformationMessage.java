package lotto.utils.constant;

public enum InformationMessage {
    BUY("%n%d개를 구매했습니다.%n"),
    PROFIT("총 수익률은 %.1f%%입니다."),
    MATCH_NUMBER("%d개 일치 (%s원) - %d개%n"),
    MATCH_NUMBER_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n");

    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
