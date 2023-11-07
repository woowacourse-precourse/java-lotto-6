package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @ParameterizedTest
    @DisplayName("양의 정수인 문자열을 구매금액으로 파싱")
    @CsvSource(value = {"1:1", "2:2", "3:3", "100:100"}, delimiter = ':')
    void parsePurchaseAmount_양의_정수(String input, Integer expected) {
        Integer parsed = StringParser.parsePurchaseAmount(input);

        assertThat(parsed).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 문자열을 구매금액으로 파싱 시 예외 발생")
    @ValueSource(strings = {"asd", "-11", "0", "00", "dk124", "..."})
    void parsePurchaseAmount_양의_정수가_아닌_문자열(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parsePurchaseAmount(input);
        });
    }

    @Test
    @DisplayName("양의 정수 배열인 문자열을 당첨 번호로 파싱")
    void parseWinningNumber_양의_정수_배열() {
        String str = "1,2,3,4,5,6,7";
        WinningNumber winningNumber = StringParser.parseWinningNumber(str);

        WinningNumber expected = new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7));

        assertThat(winningNumber.getNumbers()).isEqualTo(expected.getNumbers());
    }

    @ParameterizedTest
    @DisplayName("양의 정수 배열이 아닌 문자열을 당첨 번호로 파싱 시 예외 발생")
    @ValueSource(strings = {"1,2,3,d,5", "1,2,,4,5", ",2,3,4", "1,2, ,3,4", "1, 2, 3"})
    void parseWinningNumber_양의_정수_배열_아님(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            StringParser.parseWinningNumber(input);
        });
    }
}