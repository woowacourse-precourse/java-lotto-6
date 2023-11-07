package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    private List<Score> scores;
    private Long profit;

    public Result() {
        this.scores = new ArrayList<>();
        this.profit = null;
    }
    public Long getProfit() {
        return this.profit;
    }

    public void makeScores(List<Integer> winningNumbers, Integer bonusNumber,List<Lotto> lottos) {
        lottos.forEach(lotto -> scores
                .add(makeScore(winningNumbers, bonusNumber, lotto.getNumbers())));
    }

    private Score makeScore(List<Integer> winningNumbers, Integer bonusNumber, List<Integer> numbers) {
        int point = calculatePoint(winningNumbers, numbers);
        return decideScore(point, bonusNumber,numbers);
    }
    
    private int calculatePoint(List<Integer> winningNumbers, List<Integer> numbers) {
        Set<Integer> setWinning = new HashSet<>(winningNumbers);
        Set<Integer> setNumbers = new HashSet<>(numbers);
        setWinning.retainAll(setNumbers);
        return Constants.LOTTONUMBER - setWinning.size();
    }
    
    private Score decideScore(int point, Integer bonusNumber, List<Integer> numbers) {
        if(point == 5) {
            return aboutFive(numbers, bonusNumber);
        }
        return Score.valueOf(point);
    }
    
    private Score aboutFive(List<Integer> numbers, Integer bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            return Score.SECOND;
        }
        return Score.THIRD;
    }
    
}
