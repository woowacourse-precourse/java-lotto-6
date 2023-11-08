package lotto.domain.model.lotto;

import lotto.domain.model.result.WinningRankCalculator;
import lotto.domain.model.result.WinningRankCounts;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(final List<Lotto> lottos) {
        this.lottos = lottos;

    }

    public WinningRankCounts collectWinningRanks(WinningRankCalculator calculator,
                                                 LottoWinningNumbers lottoWinningNumbers) {
        WinningRankCounts counts = new WinningRankCounts();

        lottos.stream()
                .map(lotto -> calculator.determineWinningRank(lotto, lottoWinningNumbers))
                .forEach(counts::incrementCount);

        return counts;
    }

    public Integer getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
