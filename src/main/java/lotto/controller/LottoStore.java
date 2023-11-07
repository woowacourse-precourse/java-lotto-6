package lotto.controller;


import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.view.OutputView;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseLotto;
import lotto.domain.WinningResultCalculator;


public class LottoStore {
    private static int amount;
    private static List<Lotto> lotto;
    private static Lotto lottoData;
    private static BonusNumber bonusNumber;

    public void playLottoGame() {
        try {
            purchaseLotto();
            setWinningNumbers();
            showWinningStatics();
        } catch (NumberFormatException exception) {
            System.out.println("0보다 크고 2,147,483,647 이하의 값을 입력해 주셔야 합니다.");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        int numberOfLottoPurchased = purchaseAmount.getNumberOfLottoPurchased();
        amount = purchaseAmount.getAmount();

        PurchaseLotto purchaseLotto = setPurchaseLotto(numberOfLottoPurchased);
        lotto = purchaseLotto.getPurchaseLottos();

        printPurchaseInform(numberOfLottoPurchased, lotto);
    }

    private void setWinningNumbers() {
        lottoData = setWinningNumber();
        bonusNumber = setBonusNumbers(lottoData);
    }

    private void showWinningStatics() {
        WinningResultCalculator winningResultCalculator = new WinningResultCalculator();
        winningResultCalculator.calculateNumberOfWins(lotto, lottoData, bonusNumber.getBonusNumber());

        HashMap<LottoData, Integer> winningHistories = winningResultCalculator.getWinningData();
        String rateOfReturn = winningResultCalculator.calculateRateOfReturn(amount);

        OutputView.printStatics(winningHistories);
        OutputView.printRateOfReturn(rateOfReturn);
    }

    private PurchaseAmount setPurchaseAmount() {
        return new PurchaseAmount(InputView.enterAmount());
    }

    private PurchaseLotto setPurchaseLotto(int numberOfLottoPurchased) {
        return new PurchaseLotto(numberOfLottoPurchased);
    }

    private void printPurchaseInform(int numberOfLottoPurchased, List<Lotto> lotto) {
        OutputView.printLottoPurchasedCount(numberOfLottoPurchased);
        OutputView.printLottosList(lotto);
    }

    private Lotto setWinningNumber() {
        return new Lotto(InputView.enterWinningNumber());
    }

    private BonusNumber setBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(InputView.enterBonusNumber(), winningNumbers);
    }


}
