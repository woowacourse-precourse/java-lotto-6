package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("당첨 번호의 개수가 6개 초과하면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;
        // when

        // then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_LOTTO_NUMBERS_NOT_SIX.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicated() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;
        // when

        // then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_LOTTO_NUMBERS_DUPLICATED.getMessage());
    }

    @DisplayName("당첨 번호에 1에서 45 사이의 숫자보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverRange() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 6;
        // when

        // then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createWinningNumberByBonusNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        // when

        // then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_BONUS_NUMBER_DUPLICATED.getMessage());
    }

    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByBonusNumberOverRange() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;
        // when

        // then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }
}
