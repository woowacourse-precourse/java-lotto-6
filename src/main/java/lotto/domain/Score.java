package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Score {
    List<Integer> scores;

    public Score(List<Integer> scores) {
        this.scores = scores;
    }

    public long getPrize() {
        int revenue = 0;
        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            revenue += Rank.prize(score);
        }
        return revenue;
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
