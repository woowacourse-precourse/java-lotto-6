package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {

    @Test
    public void testCreateWinningNumbers() {
        // 유효한 로또 번호와 보너스 번호를 입력하여 객체 생성
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "7");

        // 객체의 메서드를 통해 값을 검증
        assertEquals(winningNumbers.getNumbers(), List.of(1, 2, 3, 4, 5, 6));
        assertEquals(winningNumbers.getBonus(), 7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3, ,5,6", "a,b,c,1,2,3", "", " "})
    @DisplayName("당첨 번호는 숫자여야 함")
    public void testCreateWinningNumbersWithInvalidInput1(String numbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(numbers, "8");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("당첨 번호는 6개여야함")
    public void testCreateWinningNumbersWithInvalidInput2(String numbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(numbers, "8");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,2,3,4,5,6"})
    @DisplayName("당첨 번호는 1~45 사이의 숫자여야함")
    public void testCreateWinningNumbersWithInvalidInput3(String numbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(numbers, "8");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "a"})
    @DisplayName("당첨 번호는 숫자여야 함")
    public void testCreateWinningNumbersWithInvalidInput4(String bonus) {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers("1,2,3,4,5,6", bonus);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스는 1~45 사이의 숫자여야함")
    public void testCreateWinningNumbersWithInvalidInput5(String bonus) {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers("1,2,3,4,5,6", bonus);
        });
    }


}