package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;
import lotto.domain.Purchase;
import lotto.domain.Statistics;

public class Application {
    public static void main(String[] args) {
        System.out.println(Constant.amount);
        Purchase purchase = new Purchase(Console.readLine());

        System.out.println("\n" + purchase.getAmount() + Constant.purchaseCount);
        purchase.printPurchasedLotto();

        System.out.println(Constant.winningNumber);
        WinningLotto winningLotto = new WinningLotto();

        Statistics statistics = new Statistics(purchase, winningLotto);
        statistics.matchLotto();

        System.out.println(Constant.result);
        statistics.getRank();
    }
}
