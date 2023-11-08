package lotto.dto;

public class WinningMatchResult {
    private final int matchCount;
    private final boolean matchBonus;

    public WinningMatchResult(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
