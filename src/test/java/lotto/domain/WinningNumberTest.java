package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8);
        });
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 5), 8);
        });
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 46), 8);
        });
    }

    @DisplayName("당첨 번호는 오름차순으로 정렬된다.")
    @Test
    void createWinningNumberByUnsortedNumber() {
        WinningNumber numbers = new WinningNumber(Arrays.asList(6, 5, 4, 3, 2, 1), 7);
        assertThat(numbers.getWinningNumber()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

    @DisplayName("보너스 번호가 1에서 45까지의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 46);
        });
    }
}