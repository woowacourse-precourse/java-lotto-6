package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외를 발생시킨다.")
    @Test
    void bonusNumberInWinningNumbers() {
        Assertions.assertThatThrownBy(() -> {
                    new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되지 않으면 예외를 발생시키지 않는다.")
    @Test
    void bonusNumberNotInWinningNumbers() {
        Assertions.assertThatCode(() -> {
                    new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
                })
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 로또에 포함되면 true를 반환한다.")
    @Test
    void isBonusNumberIn() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        //when
        boolean isBonusNumberIn = winningLotto.isBonusNumberIn(lotto);
        //then
        assertTrue(isBonusNumberIn);
    }

    @DisplayName("보너스 번호가 로또에 포함되지 않으면 false를 반환한다.")
    @Test
    void isBonusNumberNotIn() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        //when
        boolean isBonusNumberIn = winningLotto.isBonusNumberIn(lotto);
        //then
        assertFalse(isBonusNumberIn);
    }
}