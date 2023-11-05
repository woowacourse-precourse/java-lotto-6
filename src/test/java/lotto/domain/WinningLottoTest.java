package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {


    @DisplayName("구매한 로또와 비교해서 당첨 등수를 산출한다.")
    @Test
    void rankCalculateTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of("1", "2", "3", "5", "7", "8"), "9");
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 5, 7, 9));
        Lotto lotto3 = new Lotto(List.of(1, 2, 11, 12, 13, 14));
        //when
        Rank rank4 = winningLotto.calculateRankWith(lotto1);
        Rank rank2 = winningLotto.calculateRankWith(lotto2);
        Rank rankNone = winningLotto.calculateRankWith(lotto3);

        //then
        Assertions.assertThat(rank4).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(rank2).isEqualTo(Rank.SECOND);
        Assertions.assertThat(rankNone).isEqualTo(Rank.NONE);

    }

}
