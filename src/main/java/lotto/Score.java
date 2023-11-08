package lotto;

import java.util.List;

public class Score {
    List<Integer> scores;

    public Score(List<Integer> scores) {
        this.scores = scores;
        getPrize();
    }

    public int getPrize() {
        int revenue = 0;
        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            revenue += Rank.prize(score);
        }
        return revenue;
    }
}
