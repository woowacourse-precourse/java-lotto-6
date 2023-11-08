package lotto.constants;

public enum Result {
    THREE_MATCH("3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개\n"),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개\n");
    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
