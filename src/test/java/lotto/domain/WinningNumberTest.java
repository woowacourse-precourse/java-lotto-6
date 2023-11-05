package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.constant.WinnerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    @DisplayName("일치하는 로또 번호 개수에 따라 적절한 당첨 등수를 리턴할 수 있다.")
    void winningType() {
        // given
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        // when
        Lotto expectFirstPlace = new Lotto(List.of(5, 4, 3, 2, 1, 6));
        Lotto expectSecondPlace = new Lotto(List.of(7, 5, 4, 2, 1, 3));
        Lotto expectThirdPlace = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto expectFourthPlace = new Lotto(List.of(4, 5, 6, 1, 7, 9));
        Lotto expectFifthPlace = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        Lotto expectNonePlace = new Lotto(List.of(1, 2, 45, 44, 43, 42));

        // then
        assertAll(
                () -> assertThat(winningNumber.calcWinner(expectFirstPlace)).isEqualTo(WinnerType.FIRST),
                () -> assertThat(winningNumber.calcWinner(expectSecondPlace)).isEqualTo(WinnerType.SECOND),
                () -> assertThat(winningNumber.calcWinner(expectThirdPlace)).isEqualTo(WinnerType.THIRD),
                () -> assertThat(winningNumber.calcWinner(expectFourthPlace)).isEqualTo(WinnerType.FOURTH),
                () -> assertThat(winningNumber.calcWinner(expectFifthPlace)).isEqualTo(WinnerType.FIFTH),
                () -> assertThat(winningNumber.calcWinner(expectNonePlace)).isEqualTo(WinnerType.NOTHING)
        );
    }
}
