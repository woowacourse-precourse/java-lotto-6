package view;

import static lotto.constant.message.Output.*;
import static lotto.constant.message.Input.*;


import java.util.List;
import lotto.Lotto;
import lotto.Purchase;

public class OutputView {
    public void printPurchase() {
        System.out.println(PRICE.getMessage());
    }

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + PURCHASE.getMessage());
    }

    public void printPurchaseLotto(Purchase purchase) {
        List<Lotto> myLotto = purchase.getMyLotto(purchase.getPurchaseAmount());
        for (Lotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public void printEnterWinning() {
        System.out.println(WIN.getMessage());
    }

    public void printEnterBonus() {
        System.out.println(BONUS.getMessage());
    }

}
