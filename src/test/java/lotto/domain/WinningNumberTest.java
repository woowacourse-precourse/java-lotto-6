package lotto.domain;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @DisplayName("당첨 번호와 보너스 번호가 정상적으로 생성된다.")
    @Test
    void createWinningNumberWithValidValues() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        bonusNumber = 35;

        // when
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        // then
        assertThat(winningNumber).isNotNull().isInstanceOf(WinningNumber.class);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(bonusNumber);
        for (int number : winningNumbers) {
            assertThat(winningNumber.isContain(number)).isTrue();
        }
    }

    @DisplayName("당첨 번호에 중복된 숫자가 입력되면 예외가 발생한다.")
    @Test
    void createWinningNumberWithDuplicates() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 25);
        bonusNumber = 35;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningNumberWithDuplicateBonus() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        bonusNumber = 30;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberWithMinValue() {
        // given
        winningNumbers = Arrays.asList(0, 10, 15, 20, 25, 30);
        bonusNumber = 35;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberWithMaxValue() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 50);
        bonusNumber = 35;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작은 숫자면 예외가 발생한다.")
    @Test
    void createWinningNumberWithSmallBonus() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        bonusNumber = 0;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자면 예외가 발생한다.")
    @Test
    void createWinningNumberWithLargeBonus() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        bonusNumber = 50;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 비어있으면 예외가 발생한다.")
    @Test
    void createWinningNumberWithNoValue() {
        // given
        winningNumbers = Arrays.asList();
        bonusNumber = 35;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 비어있으면 예외가 발생한다.")
    @Test
    void createWinningNumberWithNoBonus() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        String invalidBonusNumber = "";

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, Integer.parseInt(invalidBonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void createWinningNumberWithNonNumeric() {
        // given
        winningNumbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        String invalidBonusNumber = "abc";

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumbers, Integer.parseInt(invalidBonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
