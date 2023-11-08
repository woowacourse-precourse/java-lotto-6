package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    public void setWinningNumbers() {
        winningNumbers = new WinningNumbers();
    }


    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    public void 당첨_번호_입력_테스트_1() {
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @Test
    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    public void 당첨_번호_입력_테스트_2() {
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 46));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 46));
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스가 1~45 사이의 숫자가 아니면 예외가 발생한다")
    public void 보너스_번호_입력_테스트_1(int bonus) {
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 6));
            winningNumbers.setBonus(bonus);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    public void 보너스_번호_입력_테스트_2(int bonus) {
        assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.setNumbers(List.of(1, 2, 3, 4, 5, 6));
            winningNumbers.setBonus(bonus);
        });
    }
}