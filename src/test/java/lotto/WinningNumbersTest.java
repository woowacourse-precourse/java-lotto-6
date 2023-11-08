package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외처리 한다.")
    void validateWinningNumbersIncorrectCount() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개면 정상 동작한다.")
    void validateWinningNumbersCorrectCount() {
        Lotto WinningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(WinningNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아니면 예외처리한다.")
    void validateRangeOfWinningNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(10, 55, 42, 33, 22, 11)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(10, 10, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
