package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    WinningLotto winningLotto;

    @DisplayName("당첨번호에 보너스넘버가 중복되지 않으면 정상 처리된다.")
    @Test
    void create() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");

        //when
        winningLotto = WinningLotto.create(winningNumbers, bonusNumber);

        //then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("당첨번호와 보너스넘버가 중복되면 예외가 발생한다.")
    @Test
    void cannotCreate_duplicate() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("1");

        // when, then
        assertThatThrownBy(() -> WinningLotto.create(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}