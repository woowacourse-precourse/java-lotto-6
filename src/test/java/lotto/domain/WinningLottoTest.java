package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 발행 테스트")
class WinningLottoTest {
    private WinningLotto winningLotto;
    private Lotto lotto;
    @Test
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(()-> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 보너스 번호는 1부터 45까지 존재합니다.");
    }

    @Test
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(()-> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 로또 번호에 보너스 번호와 중복된 번호가 존재합니다.");
    }

    @Test
    void 당첨_1등_테스트() {
        assertThat(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7)
                .lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @Test
    void 당첨_2등_테스트() {
        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.lottoNumbersMatch(lotto)).isEqualTo(5);
        assertThat(winningLotto.lottoBonusNumberMatch(lotto)).isTrue();
    }


    @Test
    void 당첨_3등_테스트() {
        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.lottoNumbersMatch(lotto)).isEqualTo(5);
        assertThat(winningLotto.lottoBonusNumberMatch(lotto)).isFalse();
    }


    @Test
    void 당첨_4등_테스트() {
        assertThat(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7)
                .lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 4, 8, 7)))).isEqualTo(4);
    }


    @Test
    void 당첨_5등_테스트() {
        assertThat(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7)
                .lottoNumbersMatch(new Lotto(List.of(1, 2, 3, 10, 11, 45)))).isEqualTo(3);
    }

    @Test
    void 미당첨_테스트() {
        assertThat(new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 7)
                .lottoNumbersMatch(new Lotto(List.of(45, 44, 43, 42, 6, 5)))).isEqualTo(0);
    }
}