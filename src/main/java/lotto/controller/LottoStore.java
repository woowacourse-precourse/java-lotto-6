package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoStore {
    private static int price;
    private static List<Lotto> lottos;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;
    private static final String NUMBER_FORMAT_EXCEPTION="0보다 크고 2,147,483,647 이하의 값을 입력해 주셔야 합니다.";

    public void lottoGameStart() {
        try {
            purchaseLotto();
            lottoProcess();
            showStatistics();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void showStatistics() {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateNumberOfWins(lottos, winningNumbers,bonusNumber.getBonusNumber());

        HashMap<Rank, Integer> winningHistories = winningStatistics.getWinningHistory();
        String rateOfReturn = winningStatistics.calculateRateOfReturn(price);

        OutputView.printStatics(winningHistories);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private void purchaseLotto() {
        LottoTotalPrice lottoTotalPrice1 = setPrice();
        int numberOfPurchasedLotto = lottoTotalPrice1.getNumberOfPurchasedLotto();
        price = lottoTotalPrice1.getPrice();

        PurchasedLotto purchasedLotto1 = setPurchasedLottos(numberOfPurchasedLotto);
        lottos = purchasedLotto1.getPurchasedLottos();

        printPurchaseInformation(numberOfPurchasedLotto, lottos);
    }

    private void lottoProcess() {
        winningNumbers = setWinningNumbers();
        bonusNumber = setBonusNumbers(winningNumbers);
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
    private Lotto setWinningNumbers() {
        return new Lotto(InputView.inputWinningNumber());
    }

    private BonusNumber setBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(InputView.inputBonusNumber(), winningNumbers);
    }

}
