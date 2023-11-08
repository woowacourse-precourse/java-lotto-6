package lotto.view;

import lotto.Lotto;
import lotto.domain.Calculator;
import lotto.domain.Rank;
import lotto.domain.RankContainer;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;



class SystemOutputTest {

    @Test
    void checkPrintRankResult() {
        RankContainer rankContainer = new RankContainer();
        Calculator calculator = new Calculator();

        main.java.lotto.domain.WinningLottos winningLottos = new main.java.lotto.domain.WinningLottos(Arrays.asList(
                new Lotto(List.of(1, 2, 8, 9, 42, 45)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45))
        ));

        UserLotto userLotto = new UserLotto(List.of(1, 2, 8, 9, 10, 11), 12);

        calculator.match(rankContainer, userLotto, winningLottos);

        int cnt = 0;
        for (Rank rank : Rank.values()) {
            cnt += rankContainer.getRankContainer(rank) * rank.getAward();
        }

        int money = 6000;

        double rate = (cnt * 0.1) / ((money) / 1000);
        SystemOutput.printRankResult(rankContainer, rate);
    }

}