package lotto.controller;

import java.util.List;

import lotto.views.InputViews;
import lotto.views.OutputViews;
import lotto.domain.Lotto;
import lotto.domain.MakeLottos;

public class LottoController {
    int purchaseAmount, purchaseNum;
    private static List<List<Integer>> allLotto;


    public void run() {
        while (readPurchaseLotto()) {
        }
        OutputViews.endOfSection();
        OutputViews.numOfPurchaseLotto(purchaseNum);
        allLotto = MakeLottos.makeLotto(purchaseNum);
    }

    public boolean readPurchaseLotto() {
        String purchaseAmountString = InputViews.readPurchaseAmount();
        if (ReadPurchaseLottoModules.isPurchaseAmountInt(purchaseAmountString)) {
            return true;
        }

        purchaseAmount = Integer.parseInt(purchaseAmountString);
        if (ReadPurchaseLottoModules.isPurchaseAmountPositive(purchaseAmount)) {
            return true;
        }
        if (ReadPurchaseLottoModules.isPurchaseAmountDivisible1000(purchaseAmount)) {
            return true;
        }
        purchaseNum = purchaseAmount / 1000;
        return false;
    }
}
