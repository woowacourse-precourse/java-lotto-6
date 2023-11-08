package lotto.model;

import java.util.Map;
import lotto.utils.constant.Rank;

public class LottoProfit {
    private final Map<Rank, Integer> lottoResult;
    private final Money money;
    private Double result;

    public LottoProfit(Map<Rank, Integer> lottoResult, Money money) {
        this.lottoResult = lottoResult;
        this.money = money;
    }

    public Double getResult(){
        calculate();
        return result;
    }

    private void calculate() {
        result = ((double) calculateSum() / money.getMoney()) * 100;
    }

    private int calculateSum() {
        int sum = 0;
        sum += lottoResult.get(Rank.FIRST) * 2000000000;
        sum += lottoResult.get(Rank.SECOND) * 30000000;
        sum += lottoResult.get(Rank.THIRD) * 1500000;
        sum += lottoResult.get(Rank.FOURTH) * 50000;
        sum += lottoResult.get(Rank.FIFTH) * 5000;
        return sum;
    }
}