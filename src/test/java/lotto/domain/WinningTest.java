package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @DisplayName("당첨 번호를 저장한다.")
    @Test
    void saveWinningNumbers() {
        //Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Winning winning = new Winning();
        //When
        winning.setNumbers(numbers);
        //Then
        assertThat(winning.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("당첨 번호가 6자리 보다 크다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByOverCount() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 길이는 6자리 입니다.");
    }

    @DisplayName("당첨 번호가 6자리 보다 작다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByUnderCount() {
        Winning winning = new Winning();
        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 길이는 6자리 입니다.");
    }

    @DisplayName("당첨 번호가 중복된다면 예외가 발생한다.")
    @Test
    void saveWinningNumbersByDuplicate() {
        Winning winning = new Winning();

        assertThatThrownBy(() -> winning.setNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}