package lotto.domain;

import lotto.Lotto;
import lotto.view.LottoWinningStatisticsView;

import java.util.List;

public class LottoWinningResultDomain {
    private static List<Lotto> purchaseLotto;
    private static List<Integer> winningLottoNumber;

    public LottoWinningResultDomain(List<Lotto> purchaseLotto, List<Integer> winningLottoNumber) {
        LottoWinningResultDomain.purchaseLotto = purchaseLotto;
        LottoWinningResultDomain.winningLottoNumber = winningLottoNumber;
    }

    public void lottoWinningResultLogic() {
        List<Integer> lottoStatistics = lottoStatisticsCalculation();
        lottoStatisticsView(lottoStatistics);
    }

    private List<Integer> lottoStatisticsCalculation() {
        LottoStatisticsDomain lottoStatisticsDomain = new LottoStatisticsDomain(purchaseLotto, winningLottoNumber);
        return lottoStatisticsDomain.lottoStatistics();
    }

    private void lottoStatisticsView(List<Integer> lottoStatistics) {
        LottoWinningStatisticsView lottoWinningStatisticsView = new LottoWinningStatisticsView();
        lottoWinningStatisticsView.lottoStatisticsView(lottoStatistics);
    }
}
