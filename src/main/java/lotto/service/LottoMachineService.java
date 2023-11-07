package lotto.service;

import java.util.List;
import lotto.Money;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class LottoMachineService {
    private final LottoMachine lottoMachine;

    public LottoMachineService(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<List<Integer>> generateLotto(Money money) {
        return lottoMachine.generateLotto(money);
    }

    public List<Lotto> getLottos() {
        return lottoMachine.getLottos();
    }
}
