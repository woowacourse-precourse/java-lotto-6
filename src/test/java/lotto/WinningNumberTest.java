package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개 미만이면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_winning_number_under_size() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_winning_number_duplicate() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 최댓값보다 크면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_winning_number_over_max() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 최솟값보다 작으면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void create_winning_number_under_min() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최대값보다 크면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void add_bonus_number_over_max() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.addBonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 최솟값보다 작으면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void add_bonus_number_under_min() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.addBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void add_bonus_duplicate() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.addBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}