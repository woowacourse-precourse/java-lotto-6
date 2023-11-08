package lotto;

import lotto.domain.Purchase;
import lotto.domain.Ranking;
import lotto.domain.Statistics;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        final Purchase purchasedLotto = new Purchase(Input.amount());
        Output.purchasedLotto(purchasedLotto);

        final WinningLotto winningLotto = new WinningLotto(Input.winningNumbers(), Input.bonusNumber());

        final Ranking ranking = new Ranking(purchasedLotto, winningLotto);

        final Statistics statistics = new Statistics(ranking, purchasedLotto);
        Output.rank(statistics);
        Output.revenue(statistics);
    }
}
