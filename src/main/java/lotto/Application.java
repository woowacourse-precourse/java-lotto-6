package lotto;

import lotto.constant.Constant;
import lotto.domain.Purchase;
import lotto.domain.Ranking;
// import lotto.domain.Statistics;

public class Application {
    public static void main(String[] args) {
        System.out.println(Constant.amount);
        Purchase purchasedLotto = new Purchase();

        System.out.println("\n" + purchasedLotto.getAmount() + Constant.purchaseCount);
        purchasedLotto.printPurchasedLotto();

        System.out.println(Constant.winningNumber);
        WinningLotto winningLotto = new WinningLotto();

        Ranking ranking = new Ranking(purchasedLotto, winningLotto);

        ranking.matchLotto();
        ranking.printRankStatus();

//        Statistics statistics = new Statistics(purchase, winningLotto);
//        statistics.matchLotto();
//
//        System.out.println(Constant.result);
//        statistics.getRank();
//        statistics.getRevenue();
    }
}
