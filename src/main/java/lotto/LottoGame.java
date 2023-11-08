package lotto;

import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.enums.Rank;

public class LottoGame {

    private final LottoResults lottoResults = new LottoResults();

    public void play(WinningLotto winningLotto, LottoTickets lottoTickets) {
        lottoTickets.compareLottos(winningLotto, lottoResults);
    }

    public Map<Rank, Integer> getResults() {
        return lottoResults.getResults();
    }

    public double calculateProfitRate(int amount) {
        return lottoResults.calculateProfitRate(amount);
    }
}
