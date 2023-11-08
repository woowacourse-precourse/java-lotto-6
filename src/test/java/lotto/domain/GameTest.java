package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    @DisplayName("당첨 번호에 숫자가 아닌 다른 값 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,e,3,4,5,6", "!,2,3,4,5,6", "1, 2,3,4,5,6", "1 ,2,3,4,5,6"})
    void createWinningNumbersByNonNumber(String winningNumbers) {
        assertThatThrownBy(() -> new Game(Utils.stringToIntegerList(winningNumbers), 0)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 숫자가 아닌 다른 값 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "e", " ", "!"})
    void createBonusNumberByNonNumber(String bonusNumber) {
        assertThatThrownBy(() -> new Game(List.of(1, 2, 3, 4, 5, 6), Utils.stringToInt(bonusNumber))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작은 숫자가 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createBonusNumberByLessRangeNumber(int bonusNumber) {
        assertThatThrownBy(() -> new Game(List.of(1, 2, 3, 4, 5, 6), bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자가 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {46, 47})
    void createBonusNumberByOverRangeNumber(int bonusNumber) {
        assertThatThrownBy(() -> new Game(List.of(1, 2, 3, 4, 5, 6), bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 값이면 예외 발생")
    @Test
    void createBonusNumberByOverlapNumber() {
        assertThatThrownBy(() -> new Game(List.of(1, 2, 3, 4, 5, 6), 1)).isInstanceOf(IllegalArgumentException.class);
    }
}
