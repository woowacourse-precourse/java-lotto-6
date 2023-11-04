package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Result {

    private final Map<Prize, Long> prizes;

    private final Money winMoney;

    public Result(final List<Prize> prizes) {
        this.prizes = prizes.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final List<Money> moneys = prizes.stream().map(Prize::getMoney).toList();
        this.winMoney = moneys.stream().reduce(Money.ZERO, Money::add);
    }

    public Long getPrizeCount(final Prize prize) {
        if (!prizes.containsKey(prize)) {
            return 0L;
        }
        return prizes.get(prize);
    }

    public Money getWinMoney() {
        return winMoney;
    }
}
