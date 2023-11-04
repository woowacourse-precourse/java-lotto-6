package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class LottoService {

    private final WinningNumbers winningNumbers;
    private final LottoMachine lottoMachine;
    private List<Lotto> lottos;

    public LottoService(WinningNumbers winningNumbers, LottoMachine lottoMachine) {
        this.winningNumbers = winningNumbers;
        this.lottoMachine = lottoMachine;
        this.lottos = Collections.emptyList();
    }

    public List<Lotto> getLottosWith(Money money) {
        lottos = lottoMachine.makeLottosWith(money);
        return lottos;
    }
}
