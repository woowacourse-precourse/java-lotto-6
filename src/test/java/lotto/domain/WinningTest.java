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

    @DisplayName("보너스 번호를 저장한다.")
    @Test
    void saveBonusNumber() {
        //Given
        Winning winning = new Winning();
        //When
        winning.setBonusNumber(7);
        //Then
        assertThat(winning.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외가 발생한다.")
    @Test
    void saveBonusNumberByDuplicate() {
        Winning winning = new Winning();
        winning.setNumbers(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> winning.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void saveBonusNumberByOverRange() {
        Winning winning = new Winning();
        winning.setNumbers(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> winning.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이 숫자 입니다.");
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void saveBonusNumberBByUnderRange() {
        Winning winning = new Winning();
        winning.setNumbers(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> winning.setBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이 숫자 입니다.");
    }
}