package lotto;

import lotto.domain.CompareLotto;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareLottoTest {
    @DisplayName("당첨 번호가 6개 같을 경우 1등")
    @Test
    void calculateFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 7)).isEqualTo(Prize.FIRST);
    }

    @DisplayName("당첨 번호가 5개 같고, 보너스 번호가 같을 경우 2등")
    @Test
    void calculateSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 7)).isEqualTo(Prize.SECOND);
    }

    @DisplayName("당첨 번호가 5개 같고, 보너스 번호가 다를 경우 3등")
    @Test
    void calculateThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 8)).isEqualTo(Prize.THIRD);
    }

    @DisplayName("당첨 번호가 4개 같을 경우 4등")
    @Test
    void calculateFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 8)).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("당첨 번호가 3개 같을 경우 5등")
    @Test
    void calculateFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 8)).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("당첨 번호가 3개 미만으로 같을 경우 꽝")
    @Test
    void calculateEmpty() {
        Lotto lotto = new Lotto(List.of(1, 2, 12, 7, 8, 9));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertThat(CompareLotto.calculate(lotto, winningLotto, 8)).isEqualTo(Prize.EMPTY);
    }
}
