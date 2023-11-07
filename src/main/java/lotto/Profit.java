package lotto;

import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;

public class Profit {
    private double profitRate;
    
    public Profit() { this.profitRate = 0; }
    
    public double getProfitRate() { return this.profitRate; }
    public void findProfitRate(Result result, int moneyYouPut) {
        List<Score> scores = result.getScores();
        int profit = 0;
        for(Score score : Score.values()) {
            int frequency = Collections.frequency(scores, score);
            profit += score.getPrize() * frequency;
            System.out.println(score.getPrize() * frequency);
        }
        this.profitRate = round((float) profit / moneyYouPut * 100 * 100) / 100.0;
    }
}
