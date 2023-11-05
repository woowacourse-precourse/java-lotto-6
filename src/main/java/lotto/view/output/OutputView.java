package lotto.view.output;

import lotto.model.LottoStatistics;
import lotto.model.Lottos;

public class OutputView {
    private LottosOutputView lottosOutputView = new LottosOutputView();
    private ResultOutputView resultOutputView = new ResultOutputView();

    public void showLottos(int numberOfLottoTickets, Lottos lottos) {
        lottosOutputView.printLottos(numberOfLottoTickets, lottos);
    }

    public void showWinningStatistics(LottoStatistics lottoStatistics) {
        resultOutputView.printWinningStatistics(lottoStatistics);
    }

    public void showTotalProfit(double totalProfit) {
        resultOutputView.printTotalProfit(totalProfit);
    }
}
