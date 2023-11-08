package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DrawNumbersTest {

    @DisplayName("입력받은 당첨 번호가 6자리가 아닌 경우 예외 발생")
    @Test
    void createDrawNumbersByOversize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> bonusNumber = List.of(1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new DrawNumbers(winningNumbers, bonusNumber));
    }

    @DisplayName("입력받은 보너스 번호가 1자리가 아닌 경우 예외 발생")
    @Test
    void createDrawNumbersByOversizeOfBonus() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> bonusNumber = List.of(1, 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new DrawNumbers(winningNumbers, bonusNumber));
    }

    @DisplayName("입력받은 당첨 번호에 중복된 숫자가 있는 경우 예외 발생")
    @Test
    void createDrawNumbersWithOverlappedNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> bonusNumber = List.of(7);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new DrawNumbers(winningNumbers, bonusNumber));
    }

    @DisplayName("입력받은 당첨 번호의 숫자가 1~45의 범위를 넘는 경우 예외 발생")
    @Test
    void createDrawNumbersWithOutOfRangeNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 50);
        List<Integer> bonusNumber = List.of(7);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new DrawNumbers(winningNumbers, bonusNumber));
    }
}
