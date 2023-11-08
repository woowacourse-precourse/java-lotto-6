package lotto.domain.enums;

public enum RankPrizeMessage {
    DEFAULT_RANK("%d개 일치 (%,d원) - %d개"),
    WITH_BONUS_RANK("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    ;

    private final String message;

    RankPrizeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
