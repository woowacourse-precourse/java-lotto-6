package lotto.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottos;
    private WinningNumber winningNumber;

    public LottoTicket(List<Lotto> lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
