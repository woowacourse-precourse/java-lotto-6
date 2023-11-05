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
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Rank rank = winningLotto.calculateRankWith(lotto);

        //then
        Assertions.assertThat(rank).isEqualTo(Rank.FOURTH);
    }

}
