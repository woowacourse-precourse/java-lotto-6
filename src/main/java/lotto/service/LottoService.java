package lotto.service;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.model.RandomLottos;
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
        return result.calculatePercent(money);
    }
}
