package lotto.constant;

public enum RankMessage {
    RANK_FIFTH("3개 일치 (%s원) - %d개"),
    RANK_FOURTH("4개 일치 (%s원) - %d개"),
    RANK_THIRD("5개 일치 (%s원) - %d개"),
    RANK_SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    RANK_FIRST("6개 일치 (%s원) - %d개");

    private final String message;

    RankMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
