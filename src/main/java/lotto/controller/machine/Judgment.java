package lotto.controller.machine;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoTicket;

import java.util.HashMap;
import java.util.List;

public class Judgment {
    private HashMap<Integer, Integer> winningStatistics;

    public Judgment() {
        winningStatistics = new HashMap<>();
    }

    private void initilizeWinningStatistics() {
        for(int count = 0; count < 6; count++) {
            winningStatistics.put(count, 0);
        }
    }

    public void judge(LottoTicket lottoTicket) {
        List<Lotto> lottos = lottoTicket.getLottos();
        WinningNumber winningNumber = lottoTicket.getWinningNumber();
        int matchCount, lottoCount;

        initilizeWinningStatistics();

        for (Lotto lotto: lottos) {
            matchCount = winningNumber.calcMatchCount(lotto);
            lottoCount = winningStatistics.get(matchCount) + 1;

            winningStatistics.put(matchCount, lottoCount);
        }
    }
}
