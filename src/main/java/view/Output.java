package view;

import static lotto.constant.message.Output.*;

import java.util.List;
import lotto.Lotto;
import lotto.Purchase;

public class Output {
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
}
