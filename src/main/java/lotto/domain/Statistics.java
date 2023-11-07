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

}
