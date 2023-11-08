package lotto;

import java.util.List;
import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.Rank;
import lotto.Model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("당첨 1등을 계산하는 테스트, 맞춘 번호 6개")
    @Test
    void calculateWinningRank1() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,35,45");
        Bonus bonus = new Bonus("30", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.FIRST;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 2등을 계산하는 테스트, 맞춘 번호 5개, 보너스 O")
    @Test
    void calculateWinningRank2() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,35,44");
        Bonus bonus = new Bonus("45", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.SECOND;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 3등을 계산하는 테스트, 맞춘 번호 5개, 보너스 X")
    @Test
    void calculateWinningRank3() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,35,44");
        Bonus bonus = new Bonus("43", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.THIRD;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 4등을 계산하는 테스트, 맞춘 번호 4개, 보너스 O")
    @Test
    void calculateWinningRank4_1() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,29,44");
        Bonus bonus = new Bonus("35", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.FOURTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 4등을 계산하는 테스트, 맞춘 번호 4개, 보너스 X")
    @Test
    void calculateWinningRank4_2() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,29,44");
        Bonus bonus = new Bonus("30", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.FOURTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 5등을 계산하는 테스트, 맞춘 번호 3개, 보너스 X")
    @Test
    void calculateWinningRank5() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,5,9,29,44");
        Bonus bonus = new Bonus("30", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.FIFTH;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 -등을 계산하는 테스트, 맞춘 로또개수 2개 이하")
    @Test
    void calculateWinningRank6() {
        Lotto randomLotto = new Lotto(List.of(1, 3, 5, 10, 35, 45));
        WinningLotto winningLotto = new WinningLotto("1,3,6,9,29,44");
        Bonus bonus = new Bonus("30", winningLotto);

        Rank actual = Rank.calculateWinningRank(randomLotto, winningLotto, bonus);
        Rank expected = Rank.NONE;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
