package lotto;

import lotto.domain.Purchase;
import lotto.domain.Ranking;
import lotto.domain.Statistics;

public class Application {
    public static void main(String[] args) {
        final Purchase purchasedLotto = new Purchase();
        purchasedLotto.printPurchasedLotto();

        final WinningLotto winningLotto = new WinningLotto();

        final Ranking ranking = new Ranking(purchasedLotto, winningLotto);
        ranking.matchLotto();

        final Statistics statistics = new Statistics(ranking, purchasedLotto);
        statistics.printRank();
        statistics.printRevenue();
    }
}
