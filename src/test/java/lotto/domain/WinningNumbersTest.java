package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {


    @Test
    @DisplayName("당첨 번호가 6개 미만일 경우 예외처리")
    void validateWinningNumbersUnderSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개 초과일 경우 예외처리")
    void validateWinningNumbersOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일반 당첨 번호가 중복되었을 경우 예외처리")
    void validateDuplicateGeneralNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일반 당첨 번호와 보너스 번호가 중복되었을 경우 예외처리")
    void validateDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 1 미만일 경우 예외처리")
    void validateUnderRangeWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 45 초과일 경우 예외처리")
    void validateOverRangeWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(46, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningNumbers 생성 테스트")
    void createWinningNumbersTest() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.getGeneralNumbers())
                .containsAll(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(winningNumbers.getBonusNumber(), 7);
    }
}