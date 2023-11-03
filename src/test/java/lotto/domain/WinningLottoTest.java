package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("1이상 45이하의 수가 아닌 보너스 번호는 생성시 예외가 발생합니다.")
    @Test
    void createBonusNumberRangeException() {
        // given
        List<String> numbersText = List.of("1", "2", "3", "4", "5", "6");
        WinningLotto winningLotto = WinningLotto.of(numbersText);

        // expected
        assertThatThrownBy(() -> winningLotto.createBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> winningLotto.createBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 중복되는 보너스 번호는 생성시 예외가 발생합니다.")
    @Test
    void createBonusNumberDuplicationException() {
        // given
        List<String> numbersText = List.of("1", "2", "3", "4", "5", "6");
        WinningLotto winningLotto = WinningLotto.of(numbersText);

        // expected
        assertThatThrownBy(() -> winningLotto.createBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 중복되지 않는 1이상 45이하의 보너스 번호를 생성합니다.")
    @Test
    void createBonusNumber() {
        // given
        List<String> numbersText = List.of("1", "2", "3", "4", "5", "6");
        WinningLotto winningLotto = WinningLotto.of(numbersText);

        // when
        winningLotto.createBonusNumber(7);
        int bonusNumber = winningLotto.getBonusNumber();

        // then
        assertThat(bonusNumber).isEqualTo(7);
    }
}