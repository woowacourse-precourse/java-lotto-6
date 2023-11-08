package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class OutputController {

    private OutputController() {
    }

    public static void purchaseLottos(List<Lotto> lottos) {
        OutputView.purchaseLotto(lottos);
    }

    public static void winningStatistics(WinningLotto winningLotto, List<Lotto> lottos, int purchaseAmount) {
        List<Integer> winningRanks = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        int totalWinningAmount = 0;
        double rateOfReturn;

        for (Lotto lotto : lottos) {
            int rank = LottoService.getRankOfLotto(lotto, winningLotto);
            winningRanks.set(rank, winningRanks.get(rank) + 1);
        }
        for (int index = 0; index < winningRanks.size(); index++) {
            totalWinningAmount += winningRanks.get(index) * LottoService.rankToAmount(index);
        }
        rateOfReturn = (double) totalWinningAmount / purchaseAmount;

        OutputView.winningStatistics(winningRanks, rateOfReturn);
    }
}
