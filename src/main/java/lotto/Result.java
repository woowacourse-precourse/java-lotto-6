package lotto;

import java.util.*;

import static java.lang.Math.round;

public class Result {
    private final List<Score> scores;
    private double profitRate;
    public Result() {
        this.scores = new ArrayList<>();
        this.profitRate = 0;
    }
    public List<Score> getScores() { return this.scores; }
    public double getProfitRate() { return this.profitRate; }


    //For Test code only
    public void setScores(List<Score> scores) {
        this.scores.addAll(scores);
    }

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
    
    
    public void findProfitRate(Result result, int moneyYouPut) {
        List<Score> scores = result.getScores();
        int profit = 0;
        for(Score score : Score.values()) {
            int frequency = Collections.frequency(scores, score);
            profit += score.getPrize() * frequency;
        }
        this.profitRate = round((float) profit / moneyYouPut * 100 * 100) / 100.0;
    }
    
}
