package lottoWinningNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import base.Converter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberInputTest {
    private WinningNumberInput winningNumberInput;
    private Converter converter;

    @BeforeEach
    void setUp() {
        winningNumberInput = new WinningNumberInput();
        converter = new Converter();
    }

    @DisplayName("문자열을 넣으면 쉼표를 기준으로 토큰화한다")
    @Test
    void tokenizeByComma() {
        String[] result = winningNumberInput.makeWinningNumberStringList("1,3,5,13,17,18", converter);
        assertThat(result).containsExactly("1", "3", "5", "13", "17", "18");
    }
}