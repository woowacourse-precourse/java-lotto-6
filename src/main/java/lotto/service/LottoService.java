package lotto.service;

import lotto.Lotto;
import lotto.domain.Member;

import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;

    public LottoService(final LottoMachine lottoMachine) {
        this.lottoMachine = new LottoMachine();
    }

    public List<Lotto> purchase(int money) {
        return lottoMachine.roulette(money);
    }
}
