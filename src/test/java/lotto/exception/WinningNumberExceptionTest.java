package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberExceptionTest {

    @DisplayName("당첨 번호에 문자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1a", "1,2,3,4,5, ", "a"})
    void createLottoByWord(String numbers) {
        WinningNumberException winningNumberException = new WinningNumberException();
        String[] inputNumbers = numbers.split(",");
        assertThatThrownBy(() -> winningNumberException.word(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
