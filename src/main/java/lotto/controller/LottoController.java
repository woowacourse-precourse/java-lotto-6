package lotto.controller;

import lotto.domain.*;
import lotto.utils.numbergenerators.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.utils.PurchaseManager.dividePurchaseAmount;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WinningLottoStorage winningLottoStorage;
    private PurchasedLotto purchasedLotto;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.winningLottoStorage = new WinningLottoStorage();
    }

    public void processLotto() {
        PurchaseAmount purchaseAmount = payOnAmount();
        buyLotto(purchaseAmount.getPurchaseAmount());

        printPurchasedLotto(purchaseAmount.getPurchaseAmount());

        storeLottoResult();
    }

    private PurchaseAmount payOnAmount() {
        try {
            return PurchaseAmount.from(inputView.insertPurchaseAmount());
        } catch (IllegalArgumentException purchaseAmountError) {
            System.out.println(purchaseAmountError.getMessage());
            return payOnAmount();
        }
    }

    private void buyLotto(int purchaseAmount) {
        purchasedLotto = getPurchasedLotto(purchaseAmount);
    }

    private PurchasedLotto getPurchasedLotto(int purchaseAmount) {
        try {
            return PurchasedLotto.of(purchaseAmount, RandomNumberGenerator.getInstance());
        } catch (IllegalArgumentException purchasedLottoError) {
            System.out.println(purchasedLottoError.getMessage());
            return getPurchasedLotto(purchaseAmount);
        }
    }

    private void printPurchasedLotto(int purchaseAmount) {
        outputView.printNumberOfPurchases(dividePurchaseAmount(purchaseAmount));
        purchasedLotto.getPurchasedLotto().stream()
                .map(Lotto::toString)
                .forEach(outputView::printPurchasedLotto);
    }

    private void storeLottoResult() {
        Lotto answerLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(answerLotto);

        for (Lotto lotto : purchasedLotto.getPurchasedLotto()) {
            int correctNumbers = lotto.countCorrectLottoNumbers(answerLotto);
            boolean correctBonusNumber = lotto.containsBonusNumber(bonusNumber.getBonusNumber());

            winningLottoStorage.store(Rank.of(correctNumbers, correctBonusNumber));
        }
    }

    private Lotto getWinningLotto() {
        List<Integer> winningNumber = inputView.insertWinningNumber();

        try {
            return new Lotto(winningNumber);
        } catch (IllegalArgumentException winningLottoError) {
            System.out.println(winningLottoError.getMessage());
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(Lotto answerLotto) {
        try {
            return BonusNumber.of(answerLotto, inputView.insertBonusNumber());
        } catch (IllegalArgumentException bonusNumberError) {
            System.out.println(bonusNumberError.getMessage());
            return getBonusNumber(answerLotto);
        }
    }
}