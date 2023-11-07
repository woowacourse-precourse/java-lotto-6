package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottos;
    private WinningNumber winningNumber;

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
