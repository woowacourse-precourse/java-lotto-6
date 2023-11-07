package lotto.dto.output;

public class RankResultDTO {
    private final int count;
    private final int reward;
    private final int matchCount;

    private RankResultDTO(int count, int reward, int matchCount) {
        this.count = count;
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public static RankResultDTO of(int count, int reward, int matchCount) {
        return new RankResultDTO(count, reward, matchCount);
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
}
