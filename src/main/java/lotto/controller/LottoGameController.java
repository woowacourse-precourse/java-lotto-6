package lotto.controller;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.LottoMachine;
import lotto.model.Ranking;
import lotto.service.LottoResultCheckService;
import lotto.model.Purchase;
import lotto.model.Statistics;
import lotto.model.WinningNumber;
import lotto.service.BonusNumberService;
import lotto.service.PurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PurchaseService purchaseService = new PurchaseService();
    private final WinningNumberService winningNumberService = new WinningNumberService();
    private final BonusNumberService bonusNumberService = new BonusNumberService();
    private final LottoResultCheckService lottoResultCheckService = new LottoResultCheckService();

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        //로또를 발급하고, 당첨번호와 보너스 번호를 입력한다.
        Purchase purchase = purchaseLottoTickets();
        LottoMachine lottoTickets = getLottoTickets(purchase);
        WinningNumber winningNumbers = getWinningNumbers();
        Bonus bonusNumber = getBonusNumber(winningNumbers);

        //발급된 로또와 당첨번호,보너스 번호를 비교하여 랭킹 리스트를 가져온다.
        List<Ranking> rankings = getLottoRanking(lottoTickets, winningNumbers, bonusNumber);
        getLotteryStatistics(rankings, purchase);
    }

    private LottoMachine getLottoTickets(Purchase purchase) {
        LottoMachine lottoMachine = new LottoMachine(purchase.getTicketCount());
        outputView.printPurchases(purchase.getTicketCount());
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());
        return lottoMachine;
    }

    private Purchase purchaseLottoTickets() {
        Purchase purchase = null;
        while (purchase == null) {
            String price = inputView.requestPrice();
            purchase = purchaseService.getPurchaseIfValid(price);
        }
        return purchase;
    }

    private WinningNumber getWinningNumbers() {
        WinningNumber winningNumber = null;
        while (winningNumber == null) {
            String winningNumbers = inputView.requestWinningNumber();
            winningNumber = winningNumberService.getWinningNumberIfValid(winningNumbers);
        }
        return winningNumber;
    }

    private Bonus getBonusNumber(WinningNumber winningNumber) {
        Bonus bonus = null;
        while (bonus == null) {
            String bonusNumber = inputView.requestBonusNumber();
            bonus = bonusNumberService.getBonusNumberIfValid(winningNumber, bonusNumber);
        }
        return bonus;
    }

    private List<Ranking> getLottoRanking(LottoMachine lottoMachine, WinningNumber winningNumber, Bonus bonus) {
        return lottoResultCheckService.checkResult(lottoMachine, winningNumber, bonus);
    }

    private void getLotteryStatistics(List<Ranking> rankings, Purchase purchase) {
        Statistics statistics = new Statistics();
        statistics.makeResultBoard();
        statistics.updateResultsFromRankings(rankings);

        outputView.printLotteryStatistics();
        outputView.printStatisticsResult(statistics.getResults());

        float result = statistics.calculateRateOfReturn(purchase);
        outputView.printRateOfReturn(result);
    }
}
