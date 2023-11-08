package lotto.controller.machine;

import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Judgment {
    private HashMap<Rank, Integer> winningStatistics;

    public Judgment() {
        winningStatistics = new HashMap<>();
    }

    private void initilizeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    private Rank findRank(Lotto lotto, WinningNumber winningNumber) {
        int bonusCount = winningNumber.calcBonussMatchCount(lotto);
        int totalCount = winningNumber.calcMatchCount(lotto) + bonusCount;

        return Rank.findRank(totalCount, bonusCount);
    }

    public void judge(LottoTicket lottoTicket) {
        List<Lotto> lottos = lottoTicket.getLottos();
        WinningNumber winningNumber = lottoTicket.getWinningNumber();

        initilizeWinningStatistics();

        for (Lotto lotto : lottos) {
            Rank rank = findRank(lotto, winningNumber);
            int lottoCount = winningStatistics.get(rank) + 1;

            winningStatistics.put(rank, lottoCount);
        }
    }

    public void showResult(OutputView outputView) {
        outputView.showWinningStatistics(winningStatistics);
    }
}
