package lotto.controller.machine;

import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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

    private BigDecimal calcProfit() {
        Set<Rank> keySet = winningStatistics.keySet();
        BigDecimal profit = new BigDecimal("0");

        for (Rank rank : keySet) {
            BigDecimal money = new BigDecimal(rank.getMoney());
            BigDecimal lottoCount = new BigDecimal(winningStatistics.get(rank));

            profit = profit.add(money.multiply(lottoCount));
        }

        return profit;
    }

    public void showRateOfReturn(int purchaseAmount, OutputView outputView) {
        BigDecimal profit = calcProfit().multiply(new BigDecimal("100"));
        BigDecimal rate = profit.divide(new BigDecimal(purchaseAmount))
                .setScale(1, RoundingMode.HALF_UP);

        outputView.showRateOfReturn(rate.toString());
    }
}
