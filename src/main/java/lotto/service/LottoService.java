package lotto.service;

import java.math.BigDecimal;
import lotto.domain.Computer;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoService {

    private final Computer computer;

    public LottoService(Computer computer) {
        this.computer = computer;
    }

    public int insertMoney(Money money) {
        computer.generateLottos(money);
        return money.getLottoCount();
    }


    public String getLottos() {
        return computer.getLottos();
    }

    public String getResult(WinningLotto winningLotto) {
        computer.check(winningLotto);
        return computer.getResult();
    }

    public BigDecimal getPercent(Money money) {
        return computer.calculatePercent(money);
    }
}
