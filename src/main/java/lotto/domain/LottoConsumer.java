package lotto.domain;

import java.util.List;

public class LottoConsumer {
    private final List<Lotto> issuedLottos;
    private int winningAmount;
    public LottoConsumer(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
        this.winningAmount = 0;
    }

    public int calculateWinningAmount(LottoResult lottoResult) {
        return winningAmount;
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

}
