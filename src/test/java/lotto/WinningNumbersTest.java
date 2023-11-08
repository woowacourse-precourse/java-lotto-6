package lotto;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningNumbersTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6", "7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumbersBySmallerSize() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3", "4", "6", "6"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1미만 혹은 45초과 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByNumbersNotInRange() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"0", "2", "3", "4", "6", "7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 문자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumbersWithLetters() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"a", "b", "c", "4", "6", "7"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByLetter() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3", "4", "6", "7"}).setBonus("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1미만 혹은 45초과이면 예외가 발생한다.")
    @Test
    void createBonusNumberNotInRange() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3", "4", "6", "7"}).setBonus("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createOverlappingBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"}).setBonus("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자와 로또 숫자의 일치 수만큼 정수값을 반환한다.")
    @Test
    void countNumberMatches() {
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        winningNumbers.setBonus("10");
        assertThat(winningNumbers
                .compare(new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isEqualTo(6);
    }

    @DisplayName("로또가 보너스 숫자를 포함하면 true를 반환한다.")
    @Test
    void checkIfBonusMatches() {
        WinningNumbers winningNumbers = new WinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        winningNumbers.setBonus("10");
        assertTrue(winningNumbers
                .matchesBonus(new Lotto(List.of(1, 2, 3, 4, 5, 10))));
    }

}
