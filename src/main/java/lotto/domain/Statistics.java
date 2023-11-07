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

    }

}
