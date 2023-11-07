package lotto.controller;

import java.util.List;
import lotto.model.domain.Bonus;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.Ranking;
import lotto.service.LottoResultCheckService;
import lotto.model.domain.Purchase;
import lotto.model.domain.Statistics;
import lotto.model.domain.WinningLotto;
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
        WinningLotto winningNumbers = getWinningNumbers();
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
        while(purchase == null) {
            String price = inputView.requestPrice();
            purchase = purchaseService.getPurchaseIfValid(price);
        }
        return purchase;
    }

    private WinningLotto getWinningNumbers() {
        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            String winningNumbers = inputView.requestWinningNumber();
            winningLotto = winningNumberService.getWinningNumberIfValid(winningNumbers);
        }
        return winningLotto;
    }

    private Bonus getBonusNumber(WinningLotto winningLotto) {
        Bonus bonus = null;
        while (bonus == null) {
            String bonusNumber = inputView.requestBonusNumber();
            bonus = bonusNumberService.getBonusNumberIfValid(winningLotto, bonusNumber);
        }
        return bonus;
    }

    private List<Ranking> getLottoRanking(LottoMachine lottoMachine, WinningLotto winningLotto, Bonus bonus) {
        return lottoResultCheckService.checkResult(lottoMachine.getIssuedLotto(), winningLotto, bonus);
    }

    private void getLotteryStatistics(List<Ranking> rankings, Purchase purchase) {
        Statistics statistics = new Statistics();
        statistics.makeResultBoard();
        statistics.createData(rankings);

        outputView.printLotteryStatistics();
        outputView.printStatisticsResult(statistics.getResults());

        float revenue = statistics.getRateOfReturn();
        float result = (revenue / purchase.getPrice()) * 100 ;

        outputView.printRateOfReturn(result);
    }
}
