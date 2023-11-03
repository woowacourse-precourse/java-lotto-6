package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.view.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @Test
    void lottoNumbersParseSuccessTest() {
        InputParser inputParser = new InputParser();
        String numbers = "1,2,3,4,5,6";
        assertThatCode(() -> inputParser.parseLottoNumbers(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,s,d,f", "1, 2, 3, 4", "ㄱ,ㄴ,ㄷ,ㄹ", " ", ""})
    void lottoNumbersParseFailTest(String inputNumbers) {
        InputParser inputParser = new InputParser();
        assertThatCode(() -> inputParser.parseLottoNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
