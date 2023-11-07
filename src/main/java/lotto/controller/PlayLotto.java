package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseLotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    Input input = new Input();
    Output output = new Output();
    PurchaseAmount purchaseAmount;
    PurchaseLotto purchaseLotto;
    Lotto lotto;
    BonusNumber bonusNumber;

    public void playLotto() {
        int purchaseLottoCount = getPurchaseLottoCount(input, output);
        int purchaseLottoAmount = getPurchaseLottoAmount();
        ArrayList<List<Integer>> purchaseLottoNumbers = getPurchaseLottoNumbers(output, purchaseLottoCount);
        List<Integer> winningNumbers = getWinningNumbers(input);
        int bonusNumber = getBonusNumber(input, winningNumbers);
    }

    private int getPurchaseLottoCount(Input input, Output output) {
        String amountInput;
        while (true) {
            try {
                amountInput = input.amount();
                return handlePurchaseAmount(amountInput, output);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int handlePurchaseAmount(String amountInput, Output output) {
        purchaseAmount = new PurchaseAmount(amountInput);
        int purchaseLottoCount = purchaseAmount.getLottoCount();
        int purchaseLottoAmount = purchaseAmount.getAmount();
        output.printPurchasedLottoCount(purchaseLottoCount);
        return purchaseLottoCount;
    }

    private int getPurchaseLottoAmount() {
        return purchaseAmount.getAmount();
    }

    private ArrayList<List<Integer>> getPurchaseLottoNumbers(Output output, int purchaseLottoCount) {
        purchaseLotto = new PurchaseLotto(purchaseLottoCount);
        ArrayList<List<Integer>> purchaseLottoNumbers = purchaseLotto.getPurchaseLottoNumbers();
        output.printLottoNumbers(purchaseLottoNumbers);
        return purchaseLotto.getPurchaseLottoNumbers();
    }

    private List<Integer> getWinningNumbers(Input input) {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = handleWinningNumbers(input);
                lotto = new Lotto(winningNumbers);
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> handleWinningNumbers(Input input) {
        String winningNumberInput = input.winningNumber();
        lotto = new Lotto(winningNumberInput);
        return lotto.getNumbers();
    }

    private int getBonusNumber(Input input, List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = handleBonusNumber(input, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int handleBonusNumber(Input input, List<Integer> winningNumbers) {
        String bonusNumberInput = input.bonusNumber();
        bonusNumber = new BonusNumber(bonusNumberInput, winningNumbers);
        return bonusNumber.getBonusNumber();
    }
}
