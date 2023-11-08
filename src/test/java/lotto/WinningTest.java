package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningByOverSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningOverRangeNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 50), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningBonusOverRangeNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 중복된 당첨 번호가 있으면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplication() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
