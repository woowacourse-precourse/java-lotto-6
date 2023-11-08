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

    private List<Lotto> receiveLottos(long ticketNumber) {
        List<Lotto> lottos = new LottoGenerator(ticketNumber).getLottos();
        OutputView.printLottoNumbers(lottos);
        return lottos;
    }

    private WinningNumbers receiveWinningNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.WINNING_NUMBERS.scan(), InputView.BONUS_NUMBER.scan());
        return winningNumbers;
    }

    private PrizeStats receivePrizeStats(List<Lotto> lottos, WinningNumbers winningNumbers) {
        PrizeStats prizeStats = new PrizeStats(lottos, winningNumbers);
        OutputView.printPrizeStats(prizeStats.getGradeDist());
        return prizeStats;
    }
}
