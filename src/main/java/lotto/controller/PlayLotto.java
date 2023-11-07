package lotto.controller;

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

    public void playLotto() {
        int purchaseLottoCount = getPurchaseLottoCount(input, output);
        int purchaseLottoAmount = getPurchaseLottoAmount();
        ArrayList<List<Integer>> purchaseLottoNumbers = getPurchaseLottoNumbers(output, purchaseLottoCount);
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
}
