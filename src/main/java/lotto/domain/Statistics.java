package lotto.domain;

import static lotto.constants.Constants.FIRST_PRIZE;
import static lotto.constants.Constants.SECOND_PRIZE;
import static lotto.constants.Constants.THIRD_PRIZE;
import static lotto.constants.Constants.FOURTH_PRIZE;
import static lotto.constants.Constants.FIFTH_PRIZE;
import static lotto.constants.Constants.HUNDRED;
import static lotto.constants.Constants.ZERO;
import static lotto.constants.Constants.THREE_MATCH;
import static lotto.constants.Constants.FOUR_MATCH;
import static lotto.constants.Constants.FIVE_MATCH;
import static lotto.constants.Constants.SIX_MATCH;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private final int cost;
    private final int bonusNumber;
    private final List<Integer> prizeNumbers;
    private final List<Lotto> myLotto;
    private float profitPercent;
    private long totalProfit;
    private List<Integer> prizeCount;

    public Statistics(List<Lotto> myLotto, List<Integer> prizeNumbers, int bonusNumber, int cost) {
        initializePrizeCount();
        this.myLotto = myLotto;
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
        calculate();
        computeProfit();
    }

    public float getProfitPercent() {
        return profitPercent;
    }

    public List<Integer> getPrizesCount() {
        return prizeCount;
    }

    private int correctCount(List<Integer> lotto) {
        int count = lotto.stream()
                .distinct()
                .filter(prizeNumbers::contains)
                .collect(Collectors.toSet())
                .size();
        return count;
    }

    public void initializePrizeCount() {
        prizeCount = Arrays.asList(ZERO, ZERO, ZERO, ZERO, ZERO);
    }

    private void calculate() {
        for (Lotto lotto : myLotto) {
            boolean matchBonus = false;
            int correct = correctCount(lotto.getNumbers());
            if (lotto.getNumbers().contains(bonusNumber)) {
                matchBonus = true;
            }
            matchNumber(correct, matchBonus);
        }
    }

    private void matchNumber(int correct, boolean matchBonus) {
        matchThree(correct);
        matchFour(correct);
        matchFive(correct, matchBonus);
        matchBonus(correct, matchBonus);
        matchSix(correct);
    }

    private void matchThree(int correct) {
        if (correct == THREE_MATCH) {
            prizeCount.set(0, prizeCount.get(0) + 1);
            totalProfit += FIFTH_PRIZE;
        }
    }

    private void matchFour(int correct) {
        if (correct == FOUR_MATCH) {
            prizeCount.set(1, prizeCount.get(1) + 1);
            totalProfit += FOURTH_PRIZE;
        }
    }

    private void matchFive(int correct, boolean matchBonus) {
        if (correct == FIVE_MATCH && !matchBonus) {
            prizeCount.set(2, prizeCount.get(2) + 1);
            totalProfit += THIRD_PRIZE;
        }
    }

    private void matchBonus(int correct, boolean matchBonus) {
        if (correct == FIVE_MATCH && matchBonus) {
            prizeCount.set(3, prizeCount.get(3) + 1);
            totalProfit += SECOND_PRIZE;
        }
    }

    private void matchSix(int correct) {
        if (correct == SIX_MATCH) {
            prizeCount.set(4, prizeCount.get(4) + 1);
            totalProfit += FIRST_PRIZE;
        }
    }

    private void computeProfit() {
        profitPercent = (float) totalProfit / cost * HUNDRED;
    }
}
