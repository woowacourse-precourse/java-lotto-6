package lotto.controller;

import static lotto.util.StringUtil.convertToNumber;
import static lotto.util.StringUtil.convertToNumbers;

import lotto.model.LottoVendor;
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
                String bonusNumber = InputView.askBonusNumber();
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
                lottoService.purchaseLotto(convertToNumber(paymentAmount));
                OutPutView.printLottoNumbers(lottoService.getLottoNumbers());
                break;
            }
            catch(IllegalArgumentException exception) {
                OutPutView.printErrorMessage(exception.getMessage());
            }
        }
    }

}
