package lotto.domain;

import java.util.List;
import lotto.domain.Lotto;

public class LottoConsumer {
    private final List<Lotto> issuedLottos;
    private int winningAmount;
    public LottoConsumer(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
        this.winningAmount = 0;
    }

    public int calculateWinningAmount(WinningLotto winningLotto) {
        return winningAmount;
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}
