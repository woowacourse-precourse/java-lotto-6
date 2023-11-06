package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(final List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public WinningResult calculateWinningRanks(WinningRankCalculator calculator, LottoWinningNumbers lottoWinningNumbers) {
        List<WinningRank> winningRanks = lottos.stream()
                .map(lotto -> calculator.determineWinningRank(lotto, lottoWinningNumbers))
                .toList();
        return new WinningResult(winningRanks);
    }

    public Integer getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
