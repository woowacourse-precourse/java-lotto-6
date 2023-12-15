package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class LottoService {

    private Money money;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private Result result;

    public int money(int price) {
        this.money = new Money(price);
        return money.getLottoCount();
    }

    public String lottos() {
        int count = money.getLottoCount();
        lottos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.generateLotto();
            lottos.add(lotto);
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }

    public void winningLotto(Lotto winningNumbers, int bonusNumber) {
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public String result() {
        result = new Result(winningLotto, lottos);
        return result.toString();
    }

    public BigDecimal percent() {
        return result.calculatePercent(money);
    }
}
