package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningServiceImplTest {

    WinningServiceImpl winningService = new WinningServiceImpl();

    @Test
    @DisplayName("중복된 숫자 입력 시 예외 발생")
    void winningNumberDuplicate() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 23, 28, 33, 24, 23);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("6개 이상 입력 시 예외 발생")
    void winningNumberCountOver() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 9, 3, 1, 32, 36);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 이하 입력 시 예외 발생")
    void winningNumberCount() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 9, 3, 1);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("각 번호가 1 ~ 45 범위가 아니면 예외 발생")
    void winningNumberRange() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 89, 9, 3, 1);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}