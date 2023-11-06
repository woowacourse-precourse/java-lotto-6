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

    @DisplayName("발행된 랜덤 로또, 당첨 로또, 보너스 번호가 주어졌을 때, 당첨 등수를 잘 계산하는지 테스트")
    @Test
    void calculateRank1() {
        Lotto lotto = new Lotto(List.of(1, 3, 5, 10, 11, 12));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,35,45");
        Bonus bonus = new Bonus("30");

        Assertions.assertThat(Rank.calculateRank(lotto, winningLotto, bonus)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("발행된 랜덤 로또, 당첨 로또, 보너스 번호가 주어졌을 때, 당첨 등수를 잘 계산하는지 테스트")
    @Test
    void calculateRank2() {
        Lotto lotto = new Lotto(List.of(1, 3, 5, 10, 11, 12));
        WinningLotto winningLotto = new WinningLotto("1,3,5,10,11,45");
        Bonus bonus = new Bonus("12");

        Assertions.assertThat(Rank.calculateRank(lotto, winningLotto, bonus)).isEqualTo(Rank.SECOND);
    }
}
