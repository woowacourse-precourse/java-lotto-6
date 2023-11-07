package lotto.domain;

import java.util.HashMap;

public enum RankingLotto {
    FIVE(5, 3, "5,000", "3개 일치"),
    FOUR(4, 4, "50,000", "4개 일치"),
    THREE(3, 5, "1,500,000", "5개 일치"),
    TWO(2, 5, "30,000,000", "5개 일치, 보너스 볼 일치"),
    ONE(1, 6, "2,000,000,000", "6개 일치"),
    MISS(0, 0, "0", "");
    private int rank;
    private int matchCount;
    private String reward;
    private String message;

    RankingLotto(int rank, int matchCount, String reward, String message) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getReward() {
        return reward;
    }

    public static RankingLotto matchRank(int matchCount, boolean bonus) {
        if (matchCount < 3) {
            return MISS;
        }

        if (matchCount == 6) {
            return ONE;
        }
        if (matchCount == 5 && bonus) {
            return TWO;
        }
        for (RankingLotto rankingLotto : values()) {
            if (matchCount == rankingLotto.matchCount && rankingLotto != TWO) {
                return rankingLotto;
            }
        }
        return MISS;
    }

    public static HashMap<RankingLotto, Integer> makeHashMapLottoRanking() {
        HashMap<RankingLotto, Integer> rank = new HashMap<>();

        for (RankingLotto rankingLotto : values()) {
            rank.put(rankingLotto, 0);
        }

        return rank;
    }


}
