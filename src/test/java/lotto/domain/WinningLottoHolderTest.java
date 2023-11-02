package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ExceptionMessage.LottoMachineException.BONUS_NUMBER_MUST_BE_UNIQUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoHolderTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 중복되면 예외가 발생한다")
    void throwExceptionByBonusNumberIsNotUnique() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = winningNumbers.get(0);

        // when - then
        assertThatThrownBy(() -> WinningLottoHolder.drawWinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_MUST_BE_UNIQUE.message);
    }

    @Test
    @DisplayName("WinningLottoHolder를 생성한다")
    void success() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        // when
        final WinningLottoHolder winningLottoHolder = WinningLottoHolder.drawWinningLotto(winningNumbers, bonusNumber);

        // then
        assertAll(
                () -> assertThat(winningLottoHolder.getWinningLotteryNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers),
                () -> assertThat(winningLottoHolder.getBonusNumber()).isEqualTo(bonusNumber)
        );
    }
}
