package lotto.userInterface;

import lotto.input.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest extends WinningNumbers {

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        String[] invalidInputNumbers = {"1", "2", "3", "4", "5", "5"};
        assertThatThrownBy(() -> {
            validateInput(invalidInputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 46 이상인 번호가 포함되면 예외가 발생한다.")
    @Test
    void createWinningNumberByUpperInRange() {
        String[] invalidInputNumbers = {"1", "2", "3", "4", "5", "46"};
        assertThatThrownBy(() -> {
            validateInput(invalidInputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 0 이하인 번호가 포함되면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderInRange() {
        String[] invalidInputNumbers = {"1", "2", "3", "4", "5", "0"};
        assertThatThrownBy(() -> {
            validateInput(invalidInputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 입력이 포함되면 예외가 발생한다.")
    @Test
    void createWinningNumberNotNumber() {
        String[] invalidInputNumbers = {"1", "2", "3", "4", "5", "a"};
        assertThatThrownBy(() -> {
            validateInput(invalidInputNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void validateInput(String[] inputNumbers) {
        Set<Integer>winningNumbers = new HashSet<>();
        WinningNumbers.validateInput(inputNumbers, winningNumbers);
    }
}
