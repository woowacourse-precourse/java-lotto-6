package lotto.service;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.model.RandomLottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.repository.Result;

public class LottoService {

    private final Result result;

    public LottoService(Result result) {
        this.result = result;
    }

    public void calculate(RandomLottos randomLottos, WinningLotto winningLotto) {
        result.init();
        randomLottos.getRanks(winningLotto)
                .forEach(o -> o.ifPresent(result::add));
    }

    public String getResult() {
        return result.toString();
    }

    public BigDecimal getPercent(Money money) {
        BigDecimal sum = new BigDecimal("0");
        for (Rank rank : Rank.values()) {
            sum = sum.add(rank.getPrize().multiply(new BigDecimal(result.get(rank))));
        }
        return sum.divide(money.getBigDecimalPrice()).multiply(new BigDecimal("100"));
    }
}
