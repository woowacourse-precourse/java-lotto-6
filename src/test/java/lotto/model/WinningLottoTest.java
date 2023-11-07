package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.IllegalArgumentMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 발행 테스트")
class WinningLottoTest {
    private final WinningLotto WINNING_LOTTO = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7);
    private Lotto lotto;

    @Test
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_RANGE_MESSAGE);
    }

    @Test
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IllegalArgumentMessage.ERROR_DUPLICATION_MESSAGE);
    }

    @Test
    void 당첨_1등_테스트() {
        assertThat(WINNING_LOTTO.lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @Test
    void 당첨_2등_테스트() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(WINNING_LOTTO.lottoNumbersMatch(lotto)).isEqualTo(5);
        assertThat(WINNING_LOTTO.lottoBonusNumberMatch(lotto)).isTrue();
    }


    @Test
    void 당첨_3등_테스트() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(WINNING_LOTTO.lottoNumbersMatch(lotto)).isEqualTo(5);
        assertThat(WINNING_LOTTO.lottoBonusNumberMatch(lotto)).isFalse();
    }


    @Test
    void 당첨_4등_테스트() {
        assertThat(WINNING_LOTTO.lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 4, 8, 7)))).isEqualTo(4);
    }


    @Test
    void 당첨_5등_테스트() {
        assertThat(WINNING_LOTTO.lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 10, 11, 45)))).isEqualTo(3);
    }

    @Test
    void 미당첨_테스트() {
        assertThat(WINNING_LOTTO.lottoNumbersMatch(new Lotto(List.of(45, 44, 43, 42, 6, 5)))).isEqualTo(0);
    }
}