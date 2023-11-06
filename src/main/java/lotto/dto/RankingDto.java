package lotto.dto;

import lotto.domain.Ranking;

public class RankingDto {

    private String rankingNumber;
    private int matchCount;
    private int reward;
    private int count;

    public RankingDto(Ranking ranking, int count) {
        rankingNumber = ranking.name();
        matchCount = ranking.getMatchCount();
        reward = ranking.getReward();
        this.count = count;
    }

    public String getRankingNumber() {
        return rankingNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }
}
