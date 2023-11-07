package lotto.controller;

import lotto.model.domain.Bonus;
import lotto.model.domain.BonusValidator;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoResultChecker;
import lotto.model.domain.Purchase;
import lotto.model.domain.Statistics;
import lotto.model.domain.WinningLotto;
import lotto.service.PurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private WinningLotto winningLotto;
    private Bonus bonus;
    private final PurchaseService purchaseService = new PurchaseService();
    private final WinningNumberService winningNumberService = new WinningNumberService();

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        Purchase purchase = purchaseLottoTickets();
        LottoMachine lottoTickets = getLottoTickets(purchase);
        WinningLotto winningNumbers = getWinningNumbers();
        getBonusNumber(winningNumbers);
        getLotteryStatistics(lottoTickets, purchase);
    }

    private LottoMachine getLottoTickets(Purchase purchase) {
        LottoMachine lottoMachine = new LottoMachine(purchase.getTicketCount());
        outputView.printPurchases(purchase.getTicketCount());
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());
        return lottoMachine;
    }

    //TODO: PurchaseService가 Purchase 반환하게 만들기
    private Purchase purchaseLottoTickets() {
        Purchase purchase = null;
        while(purchase == null) {
            String price = inputView.requestPrice();
            purchase = purchaseService.getPurchaseIfValid(price);
        }
        return purchase;
    }


    //TODO: 메서드 리팩토링
    private WinningLotto getWinningNumbers() {
        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            String winningNumbers = inputView.requestWinningNumber();
            winningLotto = winningNumberService.getWinningNumberIfValid(winningNumbers);
        }
        return winningLotto;
    }

    //TODO: 메서드 리팩토링
    private void getBonusNumber(WinningLotto winningLotto) {
        boolean isValidInput = false;
        BonusValidator validator = new BonusValidator();
        while (!isValidInput) {
            try {
                String bonusNumber = inputView.requestBonusNumber();
                int bonusInteger = validator.validateBonusIsNumeric(bonusNumber);
                validator.validateNumberBetweenInRange(bonusInteger);
                validator.validateWinningNumbersContainBonusNumber(winningLotto.getNumbers(), bonusInteger);
                bonus = new Bonus(bonusInteger);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if(bonus != null) {
                    isValidInput = true;
                }
            }
        }

    }

    private void getLotteryStatistics(LottoMachine lottoMachine, Purchase purchase) {
        LottoResultChecker resultChecker = new LottoResultChecker(lottoMachine.getIssuedLotto(), winningLotto, bonus);
        Statistics statistics = new Statistics();
        statistics.makeResultBoard();
        statistics.createData(resultChecker.checkResult());

        outputView.printLotteryStatistics();
        outputView.printStatisticsResult(statistics.getResults());

        float revenue = statistics.getRateOfReturn();
        float result = (revenue / purchase.getPrice()) * 100 ;

        outputView.printRateOfReturn(result);
    }
}
