package lotto.controller;

import static java.util.Objects.isNull;
import static lotto.common.exception.InputErrorMessage.NOT_BLANK;
import static lotto.common.exception.InputErrorMessage.NOT_NULL;
import static lotto.util.StringUtil.convertToNumber;
import static lotto.util.StringUtil.convertToNumbers;

import lotto.common.exception.InputException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoGame {

    private final LottoService lottoService;

    public LottoGame() {
        this.lottoService = new LottoService();
    }

    public void run() {
        printPurchasedLottoTickets();
        generateWinningNumberAndBonusNumber();
        printCalculatingLottoResult();
        printCalculatingProfitRate();
    }

    private void printCalculatingProfitRate() {
        double earningRate = lottoService.calculateProfitRate();
        OutPutView.printEarningRate(earningRate);
    }

    private void printCalculatingLottoResult() {
        lottoService.matchLottosWithWinningNumbers();
        OutPutView.printLottoRanks(lottoService.getLottoRanks());
    }

    private void generateWinningNumberAndBonusNumber() {
        while(true) {
            try {
                String winningNumbers = InputView.askWinningNumber();
                validateInput(winningNumbers);
                String bonusNumber = InputView.askBonusNumber();
                validateInput(bonusNumber);
                lottoService.generateWinningNumber(convertToNumbers(winningNumbers), convertToNumber(bonusNumber));
                break;
            }
            catch(IllegalArgumentException exception) {
                OutPutView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void printPurchasedLottoTickets() {
        while(true) {
            try {
                String paymentAmount = InputView.askPurchaseAmount();
                validateInput(paymentAmount);
                lottoService.purchaseLotto(convertToNumber(paymentAmount));
                OutPutView.printLottoNumbers(lottoService.getLottoNumbers());
                break;
            }
            catch(IllegalArgumentException exception) {
                OutPutView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void validateInput(String input) {
        validateInputIsNull(input);
        validateInputIsBlank(input);
    }

    private void validateInputIsNull(String input) {
        if(isNull(input)) throw new InputException(NOT_NULL);
    }

    private void validateInputIsBlank(String input) {
        if(input.isBlank()) throw new InputException(NOT_BLANK);
    }

}
