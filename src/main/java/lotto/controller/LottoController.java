package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import lotto.service.LottoPurchaseService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        String purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = getLottoTicket(purchaseAmount);
        printPurchasedLottoNumber(lottoTicket);
        WinningNumbers winningInformation = getWinningInformation();

    }

    private String getPurchaseAmount() {
        try {
            OutputView.printEnterPurchaseAmount();
            return InputView.getInputPurchaseAmount();
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getPurchaseAmount();
        }

    }

    private LottoTicket getLottoTicket(String purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        return lottoPurchaseService.purchaseLottoTicket(purchaseAmount);
    }

    private void printPurchasedLottoNumber(LottoTicket lottoTicket) {
        OutputView.printPurchasedQuantity(lottoTicket.getPurchaseQuantity());
        List<Lotto> lottoList = lottoTicket.getLottoList();
        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumber = lotto.getLotto();
            OutputView.printPurchasedLottoNumber(lottoNumber.toString());
        }
    }

    private WinningNumbers getWinningInformation() {
        String winningNumber = getWinningNumber();
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        WinningNumbers winningNumbers = winningNumbersService.generateWinningNumbers(winningNumber);

        String bonusNumber = getBonusNumber();
        winningNumbersService.setBonusNumber(winningNumbers, bonusNumber);
        return winningNumbers;
    }

    private String getWinningNumber() {
        try {
            OutputView.printEnterPurchaseAmount();
            return InputView.getInputPurchaseAmount();
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getWinningNumber();
        }
    }

    private String getBonusNumber() {
        try {
            OutputView.printEnterBonusNumber();
            return InputView.getInputBonusNumber();
        } catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getBonusNumber();
        }
    }

}
