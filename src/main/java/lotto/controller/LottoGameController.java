package lotto.controller;

import java.util.List;
import lotto.model.domain.Bonus;
import lotto.model.domain.BonusValidator;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoResultChecker;
import lotto.model.domain.Purchase;
import lotto.model.domain.PurchaseValidator;
import lotto.model.domain.Statistics;
import lotto.model.domain.WinningLotto;
import lotto.model.domain.WinningLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;
    private Bonus bonus;
    private Purchase purchase;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        purchaseLottoTickets();
        getLottoTickets();
        getWinningNumbers();
        getBonusNumber();
        getLotteryStatistics();
    }

    private void getLottoTickets() {
        lottoMachine = new LottoMachine(purchase.getTicketCount());
        outputView.printPurchases(purchase.getTicketCount());
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());
    }

    //TODO: 메서드 리팩토링
    private void purchaseLottoTickets() {
        boolean isValidInput = false;
        PurchaseValidator validator = new PurchaseValidator();
        while (!isValidInput) {
            try {
                String price = inputView.requestPrice();
                int priceInteger = validator.validateIntegerInput(price);
                int lottoCount = validator.validatePriceInThousandUnit(priceInteger);
                purchase = new Purchase(priceInteger, lottoCount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if(purchase != null) {
                    isValidInput = true;
                }
            }
        }
    }

    //TODO: 메서드 리팩토링
    private void getWinningNumbers() {
        boolean isValidInput = false;
        WinningLottoValidator validator = new WinningLottoValidator();
        while (!isValidInput) {
            try {
                String winningNumbers = inputView.requestWinningNumber();
                List<String> inputDividedByComma = validator.validateDelimiterComma(winningNumbers);
                validator.validateSixElements(inputDividedByComma);
                List<Integer> integerNumbers = validator.validateWinningNumberIsNumeric(inputDividedByComma);
                validator.validateNumberBetweenInRange(integerNumbers);
                winningLotto = new WinningLotto(integerNumbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (winningLotto != null) {
                    isValidInput = true;
                }
            }
        }
    }

    //TODO: 메서드 리팩토링
    private void getBonusNumber() {
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

    private void getLotteryStatistics() {
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
