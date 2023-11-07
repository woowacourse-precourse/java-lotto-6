package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import lotto.exception.domain.lotto.LottoDuplicateNumException;
import lotto.exception.domain.lotto.LottoNumRangeException;
import lotto.exception.domain.lotto.LottoSizeException;
import lotto.exception.domain.winningnumber.WinningNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨 번호 검증 테스트")
class WinningNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "17,31,45,9,10,1", "10 20,  30, 40, 41, 43"})
    @DisplayName("6개 숫자를 정상 입력하면 정상 객체 생성")
    void testValidInput(String validInput) {
        WinningNumbers winningNumbers = WinningNumbers.create(validInput);

        assertNotNull(winningNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1&2&3&4&5&6", "1/2/3/4/5/6", "", "one,two,three,four,five,six"})
    @DisplayName("숫자,공백,콤마 이외의 문자를 썼을 경우 예외 발생")
    void testInvalidFormat(String invalidInput) {
        assertThrows(WinningNumberFormatException.class, () -> {
            WinningNumbers.create(invalidInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("입력 숫자가 6개가 아닐 경우")
    void testInvalidSize(String invalidSizeValue) {
        assertThrows(LottoSizeException.class, () -> {
            WinningNumbers.create(invalidSizeValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,47", "0,20,30,40,42,44"})
    @DisplayName("6개 숫자 중 1~45 범위에 포함되지 않은 수가 있다면 예외 발생")
    void testOutOfRange(String invalidRangeInput) {
        assertThrows(LottoNumRangeException.class, () -> {
            WinningNumbers.create(invalidRangeInput);
        });
    }

    @Test
    @DisplayName("6개 숫자 중 중복된 숫자가 있으면 예외 발생")
    void testDuplicateNum() {
        assertThrows(LottoDuplicateNumException.class, () -> {
            WinningNumbers.create("1,1,2,3,4,5");
        });
    }
}