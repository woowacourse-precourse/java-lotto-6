package lotto.domain;

import java.util.Map;
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
