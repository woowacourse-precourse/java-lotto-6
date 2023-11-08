package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("winningNumbers 모델 검증 테스트")
public class winningNumbersTest {
    @Test
    @DisplayName("정답 번호가 1~45 범위에 있고, 중복되지 않으면 성공한다.")
    void success() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        assertThat(winningNumbers.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("정답 번호에 중복이 존재하면 예외가 발생한다.")
    void fail1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(3, 3, 3, 3, 3, 3)));
    }

    @Test
    @DisplayName("정답 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    void fail2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(1, 2, 3)));
    }

    @Test
    @DisplayName("정답 번호가 1~45 범위에 있지 않으면 예외가 발생한다.")
    void fail3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(0, 3, 40, 80, 100, 22)));
    }
}
