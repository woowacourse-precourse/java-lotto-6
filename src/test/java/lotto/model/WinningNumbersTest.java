package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("객체 생성 성공")
    @Test
    void createWinningNumbersComplete() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        for (Integer number : numbers) {
            assertTrue(winningNumbers.contains(number));
        }
    }
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호가 최대 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfMaxRangeNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호가 최소 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfMinRangeNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
