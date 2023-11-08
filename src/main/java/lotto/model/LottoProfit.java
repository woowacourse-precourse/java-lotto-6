package lotto.model;

import java.util.Map;
import lotto.utils.constant.Rank;

public class LottoProfit {
    private final static int PERCENT = 100;
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
        result = ((double) calculateSum() / money.getMoney()) * PERCENT;
    }

    private int calculateSum() {
        int sum = 0;
        sum += lottoResult.get(Rank.FIRST) * Rank.FIRST.getIntWinningMoney();
        sum += lottoResult.get(Rank.SECOND) * Rank.SECOND.getIntWinningMoney();
        sum += lottoResult.get(Rank.THIRD) * Rank.THIRD.getIntWinningMoney();
        sum += lottoResult.get(Rank.FOURTH) * Rank.FOURTH.getIntWinningMoney();
        sum += lottoResult.get(Rank.FIFTH) * Rank.FIFTH.getIntWinningMoney();
        return sum;
    }
}