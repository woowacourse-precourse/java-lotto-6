package lotto.controller.machine;

import lotto.constant.Rank;
import lotto.constant.WinningStandard;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Judgment {
    private HashMap<String, Integer> winningStatistics;

    public Judgment() {
        winningStatistics = new HashMap<>();
    }

    private void initilizeWinningStatistics() {
        for (Rank rank: Rank.values()){
            winningStatistics.put(String.valueOf(rank), 0);
        }
    }

    private String findRank(Lotto lotto, WinningNumber winningNumber){
        int matchCount = winningNumber.calcMatchCount(lotto);
        int bonussCount = winningNumber.calcBonussMatchCount(lotto);
        System.out.println(lotto.toString());
        System.out.println(matchCount + "/" + bonussCount);

        return String.valueOf(WinningStandard.getMatchType(matchCount, bonussCount));
    }

    public void judge(LottoTicket lottoTicket) {
        List<Lotto> lottos = lottoTicket.getLottos();
        WinningNumber winningNumber = lottoTicket.getWinningNumber();
        int lottoCount;

        initilizeWinningStatistics();

        for (Lotto lotto: lottos) {
            String rank = findRank(lotto, winningNumber);
            System.out.println(rank);
            lottoCount = winningStatistics.get(rank) + 1;

            winningStatistics.put(rank, lottoCount);
        }
    }

    public void showResult(OutputView outputView) {
        outputView.showWinningStatistics(winningStatistics);
    }
}
