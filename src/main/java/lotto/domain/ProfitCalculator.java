package lotto.domain;

import java.util.List;
import lotto.domain.money.Money;

public class ProfitCalculator {

    public Double calcRate(Money profit,Money purchaseAmount) {
        return profit.calcProfitRate(purchaseAmount);
    }

    public Money calcProfit(List<Rank> confirmResult) {
        return confirmResult.stream().map(Rank::getMoney).reduce(Money.ZERO, Money::sum);
    }
}
