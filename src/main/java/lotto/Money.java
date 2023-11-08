package lotto;

import java.util.Arrays;
import java.util.List;

public class Money {
    public static int revenue = 0;
    public static List<Integer> scores = Arrays.asList(0, 0, 0, 0, 0);

    public enum Score {
        FIFTH(5000),
        FOURTH(50000),
        THIRD(1500000),
        SECOND(30000000),
        FIRST(2000000000);

        private final int reward;

        Score(int reward) {
            this.reward = reward;
        }

        public int getReward() {
            return reward;
        }
    }

    public Money() {

    }

    public void saveScores(int score) {
        scores.set(score, scores.get(score) + 1);
    }

    public int addAllReward(List<Integer> scores) {
        int result = 0;

        for (int i = 0; i < 5; i++) {
            result += scores.get(i) * Score.values()[i].getReward();
        }

        return result;
    }

    public double calculateRevenue(int price, int allReward) {
        double revenue = (allReward / price) * 100;
        double result = Math.round(revenue);

        return result;
    }
}
