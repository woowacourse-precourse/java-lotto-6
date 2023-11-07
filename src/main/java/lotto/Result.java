package lotto;

import java.util.List;

public class Result {
    private List<Score> scores;
    private Long profit;
    private enum Score {
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }

    public Long getProfit() {
        return this.profit;
    }
//    private Score makeScore() {
//        
//    }
}
