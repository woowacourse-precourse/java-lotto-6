package lotto;

import lotto.domain.Purchase;
import lotto.domain.Ranking;
import lotto.domain.Statistics;
import lotto.view.Input;

public class Application {
    public static void main(String[] args) {

        final Purchase purchasedLotto = new Purchase(Input.amount());

        purchasedLotto.printPurchasedLotto();

        final WinningLotto winningLotto = new WinningLotto(Input.winningNumbers(), Input.bonusNumber());

        final Ranking ranking = new Ranking(purchasedLotto, winningLotto);
        ranking.matchLotto();

        final Statistics statistics = new Statistics(ranking, purchasedLotto);
        statistics.printRank();
        statistics.printRevenue();
    }
}
