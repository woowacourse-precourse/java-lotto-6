package lotto.dto;

public class LottoMatchResponse {
    private final int matchingCount;
    private final boolean matchBonus;

    public LottoMatchResponse(int matchingCount, boolean bonus) {
        this.matchingCount = matchingCount;
        this.matchBonus = bonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonus() {
        return matchBonus;
    }
}