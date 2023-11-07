package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    private List<Score> scores;
    public Result() {
        this.scores = new ArrayList<>();
    }
    public List<Score> getScores() { return this.scores; }

    public void makeScores(List<Integer> winningNumbers, Integer bonusNumber,List<Lotto> lottos) {
        lottos.forEach(lotto -> scores
                .add(makeScore(winningNumbers, bonusNumber, lotto.getNumbers())));
    }

    private Score makeScore(List<Integer> winningNumbers, Integer bonusNumber, List<Integer> numbers) {
        int point = calculatePoint(winningNumbers, bonusNumber, numbers);
        return decideScore(point, bonusNumber,numbers);
    }
    
    private int calculatePoint(List<Integer> winningNumbers, Integer bonusNumber, List<Integer> numbers) {
        Set<Integer> setOfWinning = new HashSet<>(winningNumbers);
        Set<Integer> setOfNumbers = new HashSet<>(numbers);
        setOfWinning.retainAll(setOfNumbers);
        return ifBonusIncluded(bonusNumber, numbers, setOfWinning);
    }
    
    private int ifBonusIncluded(Integer bonusNumber, List<Integer> numbers, Set<Integer> setOfWinning) {
        if(numbers.contains(bonusNumber)) {
            return setOfWinning.size() + 1;
        }
        return setOfWinning.size();
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
