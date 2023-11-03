package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @DisplayName("당첨 번호의 개수가 6개를 넘어가면 예외가 발생한다.")
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

    @Nested
    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    class WinningNumbersOutOfRangeTest {

        @DisplayName("범위의 아래 경곗값인 0을 포함하여 테스트")
        @Test
        void createWinningNumbersByOutOfRangeWithBelowValue() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("범위의 위 경곗값인 46을 포함하여 테스트")
        @Test
        void createWinningNumbersByOutOfRangeWithAboveValue() {
            assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
