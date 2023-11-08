package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.lotto.NonNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    @DisplayName("당첨 번호에 숫자가 아닌 다른 값 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,e,3,4,5,6", "!,2,3,4,5,6", "1, 2,3,4,5,6", "1 ,2,3,4,5,6"})
    void createWinningNumbersByNonNumber(String winningNumbers) {
        assertThatThrownBy(() -> new Game(winningNumbers)).isInstanceOf(NonNumberFormatException.class);
    }
}
