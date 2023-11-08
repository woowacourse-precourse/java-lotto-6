package lotto.controller;

import lotto.exception.InvalidDuplicateNumberException;
import lotto.exception.InvalidInputException;
import lotto.exception.InvalidPaymentAmountException;
import lotto.exception.InvalidRangeException;
import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.validation.Validator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private static final String ERROR_CODE_CATEGORY_FOR_PAYMENT = "구입 금액";
    private static final String ERROR_CODE_CATEGORY_FOR_WINNING_NUMBER = "당첨 번호";
    private static final String COMMA = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

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
                int paymentAmount = Validator.validateNumeric(enteredPaymentAmount, ERROR_CODE_CATEGORY_FOR_PAYMENT);
                outputView.generateBlank();
                int purchasedLottoCount = lottoGameService.setUpPurchasedLotto(paymentAmount);
                ArrayList<Lotto> purchasedAllLotto = lottoGameService.checkPurchasedLotto();
                outputView.printPurchasedLotto(purchasedLottoCount, purchasedAllLotto);
                break;
            } catch (InvalidInputException | InvalidPaymentAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateWinningNumber() {
        while (true) {
            try{
                String enteredWinningNumbers = inputView.enterWinningNumbers();
                List<String> defaultWinningNumbers = List.of(enteredWinningNumbers.split(COMMA));
                String enteredBonusWinningNumber = inputView.enterBonusWinningNumber();
                int bonusWinningNumber = Validator.validateNumeric(enteredBonusWinningNumber, ERROR_CODE_CATEGORY_FOR_WINNING_NUMBER);
                outputView.generateBlank();
                lottoGameService.completeMakingWinningNumber(defaultWinningNumbers, bonusWinningNumber);
                break;
            } catch (InvalidDuplicateNumberException | InvalidInputException | InvalidRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void announceGameResult() {
        lottoGameService.makeWinningData();
        int[] winningData = lottoGameService.getWinningData();
        double profitRate = lottoGameService.calculateProfitRate(winningData);
        outputView.printLottoGameResult(winningData, profitRate);
    }
}
