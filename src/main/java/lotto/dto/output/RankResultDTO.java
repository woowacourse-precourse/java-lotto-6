package lotto.dto.output;

public final class RankResultDTO {
    private final int count;
    private final int reward;
    private final int matchCount;
    private final boolean isSecondRank;

    private RankResultDTO(int count, int reward, int matchCount, boolean isSecondRank) {
        this.count = count;
        this.reward = reward;
        this.matchCount = matchCount;
        this.isSecondRank = isSecondRank;
    }

    public static RankResultDTO of(int count, int reward, int matchCount, boolean isSecondRank) {
        return new RankResultDTO(count, reward, matchCount, isSecondRank);
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isSecondRank() {
        return isSecondRank;
    }
}
