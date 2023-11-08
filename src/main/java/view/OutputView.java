package view;

import static lotto.constant.message.Output.*;
import static lotto.constant.message.Input.*;


import java.util.List;
import lotto.Lotto;
import lotto.Purchase;
import lotto.constant.message.Output;

public class OutputView {
    public void printPurchase() {
        System.out.println(PRICE.getMessage());
    }

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.println(" ");
        System.out.println(purchaseAmount + PURCHASE_CNT.getMessage());
    }

    public void printPurchaseLotto(Purchase purchase) {
        List<Lotto> myLotto = purchase.getMyLotto();
        for (Lotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public void printEnterWinning() {
        System.out.println(" ");
        System.out.println(WIN.getMessage());
    }

    public void printEnterBonus() {
        System.out.println(" ");
        System.out.println(BONUS.getMessage());
    }

    public void printResult(int six, int five, int fiveWithBonus, int four, int three) {
        System.out.println();
        System.out.println(RESULT.getMessage());
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
    }

    public void printProfit(Double rate) {
        System.out.printf(RATE.getMessage(), rate);
    }
}
