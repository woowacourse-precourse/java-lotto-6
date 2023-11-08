package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    public void run() {
        try {
            BuyingLotto buyingLotto = doBuyingLotto();
            List<Lotto> lottos = receiveLottos(buyingLotto.getTicketNumber());
            WinningNumbers winningNumbers = receiveWinningNumbers();

            PrizeStats prizeStats = receivePrizeStats(lottos, winningNumbers);
            PrizeProfit prizeProfit = receivePrizeProfit(prizeStats, buyingLotto.getBuyingPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private BuyingLotto doBuyingLotto() {
        BuyingLotto buyingLotto = new BuyingLotto(InputView.BUYING_PRICE.scan());
        OutputView.printTicketNumber(buyingLotto.getTicketNumber());
        return buyingLotto;
    }
}
