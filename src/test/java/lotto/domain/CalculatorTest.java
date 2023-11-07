package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import main.java.lotto.domain.WinningLottos;

class CalculatorTest {
    @DisplayName("calculateMatchLottoNumber메소드 정상 작동 확인")
    @Test
    void checkcalculateMatchLottoNumber() {
        Calculator calculator = new Calculator();

        Lotto winningLotto = new Lotto(List.of(1,2,8,10,11,12));
        UserLotto userLotto = new UserLotto( List.of(1, 2, 8, 9, 10, 11), 12);

        System.out.println(calculator.calculateMatchLottoNumber(userLotto, winningLotto));
    }

    @DisplayName("rankContainer에서 incRank가 정상 작동하는 지 확인하기")
    @Test
    void checkcMatch() {
        Calculator calculator = new Calculator();

        WinningLottos winningLottos = new WinningLottos(Arrays.asList(
                new Lotto(List.of(1, 2, 8, 9, 42, 45)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45))
        ));

        UserLotto userLotto = new UserLotto(List.of(1, 2, 8, 9, 10, 11), 12);

        RankContainer rankContainer = new RankContainer();
        for (Lotto lotto : winningLottos.getWiningLottos()) {
            Rank rank = Rank.valueOf(calculator.calculateMatchLottoNumber(userLotto, lotto), lotto.isContain(userLotto.getBonusNumber()));
            System.out.println(rank);
            rankContainer.incRank(rank);
        }
        assertThat(rankContainer.getRankContainer(Rank.FOURTH)).isEqualTo(1);
    }

}