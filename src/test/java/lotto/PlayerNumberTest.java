package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.PlayerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createPlayerNumberByOverSizeWinningNumber() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 8;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1보다 작은 숫자이면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasWinningNumberUnder1() {
        List<Integer> winning = List.of(0, 2, 3, 4, 5, 6);
        int bonus = 8;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 45보다 큰 숫자이면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasWinningNumberOver45() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 46);
        int bonus = 8;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasDuplicateWinningNumber() {
        List<Integer> winning = List.of(1, 1, 3, 4, 5, 6);
        int bonus = 8;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작은 숫자이면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasBonusNumberUnder1() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 0;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자이면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasBonusNumberOver45() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 46;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createPlayerNumberHasDuplicateBonusNumber() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 1;

        assertThatThrownBy(() -> new PlayerNumber(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}