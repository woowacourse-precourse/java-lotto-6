package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("WinningLotto은 Lotto가 해당 등수에 당첨됐는지 계산해줄 수 있다.")
    @Test
    void isMatchWithTrue() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        boolean isMatch1 = winningLotto.isMatch(Winning.FIRST_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        boolean isMatch2 = winningLotto.isMatch(Winning.SECOND_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        boolean isMatch3 = winningLotto.isMatch(Winning.THIRD_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        boolean isMatch4 = winningLotto.isMatch(Winning.FOURTH_PLACE, new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        boolean isMatch5 = winningLotto.isMatch(Winning.FIFTH_PLACE, new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        //then
        assertThat(isMatch1).isTrue();
        assertThat(isMatch2).isTrue();
        assertThat(isMatch3).isTrue();
        assertThat(isMatch4).isTrue();
        assertThat(isMatch5).isTrue();
    }

    @DisplayName("WinningLotto은 Lotto가 해당 등수에 당첨이 안됐는지 계산해줄 수 있다.")
    @Test
    void isMatchWithFalse() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        boolean isMatch1 = winningLotto.isMatch(Winning.FIFTH_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        boolean isMatch2 = winningLotto.isMatch(Winning.FOURTH_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        boolean isMatch3 = winningLotto.isMatch(Winning.SECOND_PLACE, new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        boolean isMatch4 = winningLotto.isMatch(Winning.THIRD_PLACE, new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        boolean isMatch5 = winningLotto.isMatch(Winning.FIRST_PLACE, new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        //then
        assertThat(isMatch1).isFalse();
        assertThat(isMatch2).isFalse();
        assertThat(isMatch3).isFalse();
        assertThat(isMatch4).isFalse();
        assertThat(isMatch5).isFalse();
    }
}