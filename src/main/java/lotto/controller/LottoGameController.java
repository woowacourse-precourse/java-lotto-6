package lotto.controller;

import lotto.exception.InvalidPaymentAmountException;
import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.validation.Validator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

//    private final Validator validator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void start() {
        purchaseLotto();
        generateWinningNumber();
        announceGameResult();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String enteredPaymentAmount = inputView.enterPaymentAmount();
                Validator.validateNumeric(enteredPaymentAmount);
                int paymentAmount = Integer.parseInt(enteredPaymentAmount);
                outputView.generateBlank();
                int purchasedLottoCount = lottoGameService.setUpPurchasedLotto(paymentAmount);
                ArrayList<Lotto> purchasedAllLotto = lottoGameService.checkPurchasedLotto();
                outputView.printPurchasedLotto(purchasedLottoCount, purchasedAllLotto);
                break;
            } catch (InvalidPaymentAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateWinningNumber() {
        String winningNumbers = inputView.enterWinningNumbers();
        List<String> defaultWinningNumbers = Validator.validateDuplicateNumber(winningNumbers);
        int bonusWinningNumber = inputView.enterBonusWinningNumber();
        lottoGameService.completeMakingWinningNumber(defaultWinningNumbers, bonusWinningNumber);
    }

    private void announceGameResult() {
        lottoGameService.makeWinningData();
        int[] winningData = lottoGameService.getWinningData();
        double profitRate = lottoGameService.calculateProfitRate(winningData);
        outputView.printLottoGameResult(winningData, profitRate);
    }
}
