package lotto.controller;

import lotto.constants.AppConstants;
import lotto.constants.ErrorConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        try {
            LottoTicket lottoTicket = getLottoTicket();
            printPurchasedLottoNumber(lottoTicket);
            WinningNumbers winningNumbers = getWinningInformation();
            printWinningStatistics(lottoTicket, winningNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private LottoTicket getLottoTicket() {
        for (int attempt = 1; attempt <= AppConstants.MAX_ATTEMPTS; attempt++) {
            try {
                String purchaseAmount = getInputPurchaseAmount();
                LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
                return lottoPurchaseService.purchaseLottoTicket(purchaseAmount);
            } catch (Exception ex) {
                OutputView.printErrorMessage(ex.getMessage());
            }
        }
        throw new IllegalArgumentException(ErrorConstants.MAXIMUM_NUMBER_OF_ATTEMPTS_EXCEEDED.getData());
    }

    private String getInputPurchaseAmount() {
        OutputView.printEnterPurchaseAmount();
        return InputView.getInputPurchaseAmount();
    }

    private WinningNumbers getWinningInformation() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        WinningNumbers winningNumbers = getWinningNumbers(winningNumbersService);
        getBonusNumber(winningNumbersService, winningNumbers);
        return winningNumbers;
    }

    private WinningNumbers getWinningNumbers(WinningNumbersService winningNumbersService) {
        for (int attempt = 1; attempt <= AppConstants.MAX_ATTEMPTS; attempt++) {
            try {
                String winningNumber = getInputWinningNumber();
                return winningNumbersService.generateWinningNumbers(winningNumber);
            } catch (Exception ex) {
                OutputView.printErrorMessage(ex.getMessage());
            }
        }
        throw new IllegalArgumentException(ErrorConstants.MAXIMUM_NUMBER_OF_ATTEMPTS_EXCEEDED.getData());
    }

    private String getInputWinningNumber() {
        OutputView.printEnterWinningNumber();
        return InputView.getInputWinningNumber();
    }

    private void getBonusNumber(WinningNumbersService winningNumbersService, WinningNumbers winningNumbers) {
        for (int attempt = 1; attempt <= AppConstants.MAX_ATTEMPTS; attempt++) {
            try {
                String bonusNumber = getInputBonusNumber();
                winningNumbersService.setBonusNumber(winningNumbers, bonusNumber);
            } catch (Exception ex) {
                OutputView.printErrorMessage(ex.getMessage());
            }
        }
        throw new IllegalArgumentException(ErrorConstants.MAXIMUM_NUMBER_OF_ATTEMPTS_EXCEEDED.getData());
    }

    private String getInputBonusNumber() {
        OutputView.printEnterBonusNumber();
        return InputView.getInputBonusNumber();
    }

    private void printPurchasedLottoNumber(LottoTicket lottoTicket) {
        OutputView.printPurchasedQuantity(lottoTicket.getPurchaseQuantity());
        List<Lotto> lottoList = lottoTicket.getLottoList();
        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumber = lotto.getLotto();
            OutputView.printPurchasedLottoNumber(lottoNumber.toString());
        }
    }

    private void printWinningStatistics(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(lottoTicket, winningNumbers);
        OutputView.printWinningStatistics(counts);
        double profitRatio = lottoService.calculateProfitRatio(lottoTicket);
        OutputView.printProfitRatio(profitRatio);
    }
}