package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoStore {
    private static int price;
    private static List<Lotto> lottos;
    private static WinningNumber winningNumbers;
    private static BonusNumber bonusNumber;

    public void lottoGameStart() {
        purchaseLotto();
        lottoProcess();
    }

    private void lottoProcess() {
        winningNumbers = setWinningNumbers();
        bonusNumber = setBonusNumbers(winningNumbers);
    }

    private void purchaseLotto() {
        LottoTotalPrice lottoTotalPrice1 = setPrice();
        int numberOfPurchasedLotto = lottoTotalPrice1.getNumberOfPurchasedLotto();
        price = lottoTotalPrice1.getPrice();

        PurchasedLotto purchasedLotto1 = setPurchasedLottos(numberOfPurchasedLotto);
        lottos = purchasedLotto1.getPurchasedLottos();

        printPurchaseInformation(numberOfPurchasedLotto, lottos);
    }

    private PurchasedLotto setPurchasedLottos(int numberOfLottoPurchased) {
        return new PurchasedLotto(numberOfLottoPurchased);
    }

    private LottoTotalPrice setPrice() {
        return new LottoTotalPrice(InputView.inputLottoPrice());
    };

    private void printPurchaseInformation(int numberOfPurchasedLotto, List<Lotto> lottos) {
        OutputView.printNumberOfPurchasedLotto(numberOfPurchasedLotto);
        OutputView.printLottosList(lottos);
    }
    private WinningNumber setWinningNumbers() {
        return new WinningNumber(InputView.inputWinningNumber());
    }

    private BonusNumber setBonusNumbers(WinningNumber winningNumbers) {
        return new BonusNumber(InputView.inputBonusNumber(), winningNumbers);
    }

    private static void getWinningNumbers() {
    }
    private void getBonusNumber() {

    }
    private void printWinningStatistics() {

    }
}
