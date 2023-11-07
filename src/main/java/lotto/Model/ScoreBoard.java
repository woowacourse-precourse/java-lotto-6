package lotto.Model;

import java.util.EnumMap;

public class ScoreBoard {
    private EnumMap<Prize, Integer> prizeScore;

    public ScoreBoard() {
        prizeScore = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeScore.put(prize, 0);
        }
    }

    public void recordScore(Prize prize) {
        prizeScore.put(prize, prizeScore.get(prize)+1);
    }

    public Integer getScoreByRank(Prize prize) {
        return prizeScore.get(prize);
    }
}