package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;
import lotto.domain.Purchase;

public class Application {
    public static void main(String[] args) {
        System.out.println(Constant.amount);
        Purchase purchase = new Purchase(Console.readLine());

        System.out.println("\n" + purchase.getAmount() + Constant.purchaseCount);
        purchase.getPurchasedLotto();

        System.out.println(Constant.winningNumber);
    }
}
