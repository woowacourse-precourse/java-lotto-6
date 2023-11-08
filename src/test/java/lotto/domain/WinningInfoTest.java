package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningInfoTest {
    @Test
    void 중복된_당첨_번호_생성_예외_처리() {
        assertThatThrownBy(() -> WinningInfo.create(List.of(1, 2, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 숫자가 존재합니다.");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복_생성_예외_처리() {
        assertThatThrownBy(() -> WinningInfo.create(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 우승 번호의 숫자와 중복될 수 없습니다.");
    }

    @Test
    void 당첨_번호_길이_예외_처리() {
        assertThatThrownBy(() -> WinningInfo.create(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 및 당첨 번호는 6개의 숫자로 구성되어야 합니다.");
    }

    @Test
    void 인자로_받은_로또의_당첨_판별() {
        WinningInfo winningInfo = WinningInfo.create(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto firstExpected = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondExpected = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto noneExpected = new Lotto(List.of(8, 7, 9, 10, 11, 21));

        assertThat(winningInfo.getPrizeResult(firstExpected)).isEqualTo(Prize.FIRST);
        assertThat(winningInfo.getPrizeResult(secondExpected)).isEqualTo(Prize.SECOND);
        assertThat(winningInfo.getPrizeResult(noneExpected)).isEqualTo(Prize.NONE);
    }
}