package lotto.domain;

import lotto.util.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private Prize prize;
    private List<Result> results;

    public Game(int cost) {
        this.player = new Player(cost);
        this.prize = new Prize();
        this.results = new ArrayList<>(5);

        for(int i = 0; i < 5; i++) {
            results.add(new Result());
        }
    }

    public void addPrize(int matchedNumbers, boolean bonusResult) {
        if(matchedNumbers < 3) return;

        int grade = LottoResult.getGrade(matchedNumbers, bonusResult);
        results.get(grade - 1).addCount();
        prize.addPrize(grade);
    }

    public List<Result> getResults() {
        return this.results;
    }

    public double getPrize() {
        return this.prize.getMoney();
    }
}
