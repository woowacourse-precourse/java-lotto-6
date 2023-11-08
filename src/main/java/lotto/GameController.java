package lotto;

import lotto.domain.*;

import java.util.List;

import static lotto.view.OutputView.*;

public class GameController {
    public void run() {
        BuyingLotto buyingLotto = doBuyingLotto();
        List<Lotto> lottos = receiveLottos(buyingLotto.getTicketNumber());
        WinningNumbers winningNumbers = new WinningNumbers();
        PrizeStats prizeStats = receivePrizeStats(lottos, winningNumbers);
        PrizeProfit prizeProfit = receivePrizeProfit(prizeStats, buyingLotto.getBuyingPrice());
    }

    private BuyingLotto doBuyingLotto() {
        BuyingLotto buyingLotto = new BuyingLotto();
        printTicketNumber(buyingLotto.getTicketNumber());
        return buyingLotto;
    }

    private List<Lotto> receiveLottos(int ticketNumber) {
        List<Lotto> lottos = new LottoGenerator(ticketNumber).getLottos();
        printLottoNumbers(lottos);
        return lottos;
    }

    private PrizeStats receivePrizeStats(List<Lotto> lottos, WinningNumbers winningNumbers) {
        PrizeStats prizeStats = new PrizeStats(lottos, winningNumbers);
        printPrizeStats(prizeStats.getGradeDist());
        return prizeStats;
    }

    private PrizeProfit receivePrizeProfit(PrizeStats prizeStats, int buyingPrice) {
        PrizeProfit prizeProfit = new PrizeProfit(prizeStats, buyingPrice);
        printProfitRate(prizeProfit.getRate());
        return prizeProfit;
    }
}
