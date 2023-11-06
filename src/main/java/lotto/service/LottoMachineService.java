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

    public List<Lotto> getLottosWith(Money money) {
        return lottoMachine.makeLottosWith(money);
    }
}
