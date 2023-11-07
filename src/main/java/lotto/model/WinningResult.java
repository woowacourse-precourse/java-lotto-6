package lotto.model;

public enum WinningResult {

    FIRST("6개 일치 (2,000,000,000원) - %d개", 0, 6, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 0, 5, true),
    THIRD("5개 일치 (1,500,000원) - %d개", 0, 5, false),
    FOURTH("4개 일치 (50,000원) - %d개", 0, 4, false),
    FIFTH("3개 일치 (5,000원) - %d개", 0, 3, false);

    private final String message;
    private int countResult;
    private final int matchCount;
    private final boolean matchBonus;

    WinningResult(String message, int countResult, int matchCount, boolean matchBonus) {
        this.message = message;
        this.countResult = countResult;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }
}
