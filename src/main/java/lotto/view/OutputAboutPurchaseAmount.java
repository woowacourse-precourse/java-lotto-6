package lotto.view;

import lotto.constant.Phrases;

public class OutputAboutPurchaseAmount {
    public static void printInputPurchaseAmoubnt() {
        System.out.println(Phrases.purchaseInputPhrase);
    }

    public static void printResultPurchase(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + Phrases.purchaseOutputPhrase);
    }
}
