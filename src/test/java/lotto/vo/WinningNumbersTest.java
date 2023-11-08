package lotto.vo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

    @DisplayName("숫자가 올바르게 포함되어 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void shouldVerifyIfNumberIsContained(int number) {
        // Given
        List<Integer> winningNumbersList = List.of(1, 2, 3, 4, 5);
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);

        // When
        boolean isContained = winningNumbers.isContained(number);

        // Then
        if (winningNumbersList.contains(number)) {
            assertTrue(isContained);
        } else {
            assertFalse(isContained);
        }
    }
}
