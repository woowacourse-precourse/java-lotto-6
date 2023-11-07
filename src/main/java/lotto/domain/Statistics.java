package lotto.domain;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.domain.Constants.ZERO;

public class Statistics {
    private List<Integer> prizes;
    private List<Lotto> myLotto;
    private List<Integer> prizeNumbers;
    private int bonusNumber;
    private float profitPercent;
    private int cost;
    private long totalProfit;

    public Statistics(List<Lotto> myLotto, List<Integer> prizeNumbers, int bonusNumber, int cost) {
        prizes = Arrays.asList(ZERO, ZERO, ZERO, ZERO, ZERO);
        this.myLotto = myLotto;
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
        calculate();
        computeProfit();
    }

    public List<Integer> getPrizes() {
        return prizes;
    }

    public float getProfitPercent() {
        return profitPercent;
    }

    private int correctCount(List<Integer> lotto) {
        int count = lotto.stream()
                .distinct()
                .filter(prizeNumbers::contains)
                .collect(Collectors.toSet())
                .size();
        return count;
    }

    private void calculate() {
        for (Lotto lotto : myLotto) {
            boolean bonus = false;
            int correct = correctCount(lotto.getNumbers());
            if (lotto.getNumbers().contains(bonusNumber)) {
                bonus = true;
            }
            matchNumber(correct, bonus);
        }
    }

    private void matchNumber(int correct, boolean bonus) {
        matchThree(correct);
        matchFour(correct);
        matchFive(correct, bonus);
        matchBonus(correct, bonus);
        matchSix(correct);
    }

    private void matchThree(int correct) {
        if (correct == 3) {
            prizes.set(0, prizes.get(0) + 1);
            totalProfit += Constants.FIFTH_PRIZE;
        }
    }

    private void matchFour(int correct) {
        if (correct == 4) {
            prizes.set(1, prizes.get(1) + 1);
            totalProfit += Constants.FOURTH_PRIZE;
        }
    }

    private void matchFive(int correct, boolean bonus) {
        if (correct == 5 && !bonus) {
            prizes.set(2, prizes.get(2) + 1);
            totalProfit += Constants.THIRD_PRIZE;
        }
    }

    private void matchBonus(int correct, boolean bonus) {
        if (correct == 5 && bonus) {
            prizes.set(3, prizes.get(3) + 1);
            totalProfit += Constants.SECOND_PRIZE;
        }
    }

    private void matchSix(int correct) {
        if (correct == 6) {
            prizes.set(4, prizes.get(4) + 1);
            totalProfit += Constants.FIRST_PRIZE;
        }
    }

    private void computeProfit() {
        profitPercent = (float) totalProfit / cost * Constants.HUNDRED;
    }
}
