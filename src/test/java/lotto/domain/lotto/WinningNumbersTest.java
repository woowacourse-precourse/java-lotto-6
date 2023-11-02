package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import lotto.exception.domain.winningnumber.WinningNumberFormatException;
import lotto.exception.domain.winningnumber.WinningNumberRangeException;
import lotto.exception.domain.winningnumber.WinningNumberSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨 번호 검증 테스트")
class WinningNumbersTest {

    @ParameterizedTest
    @MethodSource("validInputProvider")
    @DisplayName("6개 숫자를 정상 입력하면 정상 객체 생성")
    void testValidInput(String validInput) {
        WinningNumbers winningNumbers = WinningNumbers.create(validInput);

        assertNotNull(winningNumbers);
    }

    static Stream<String> validInputProvider() {
        return Stream.of(
                "1,2,3,4,5,6",
                "17,31,45,9,10,1",
                "10, 20, 30,40, 43, 45",
                "10 20, 30, 40, 41, 43",
                "10 20 30 40 41 42"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    @DisplayName("숫자,공백,콤마 이외의 문자를 썼을 경우 예외 발생")
    void testInvalidFormat(String invalidInput) {
        assertThrows(WinningNumberFormatException.class, () -> {
            WinningNumbers.create(invalidInput);
        });
    }

    static Stream<String> invalidInputProvider() {
        return Stream.of(
                "1&2&3&4&5&6",
                "1/2/3/4/5/6",
                "",
                "one,two,three,four,five,six"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidSizeValueProvider")
    @DisplayName("입력 숫자가 6개가 아닐 경우")
    void testInvalidSize(String invalidSizeValue) {
        assertThrows(WinningNumberSizeException.class, () -> {
            WinningNumbers.create(invalidSizeValue);
        });
    }

    static Stream<String> invalidSizeValueProvider() {
        return Stream.of(
                "1",
                "1,2,3,4,5",
                "1,2,3,4,5,6,7"
        );
    }

    @ParameterizedTest
    @MethodSource("invalidRangeValueProvider")
    @DisplayName("6개 숫자 중 1~45 범위에 포함되지 않은 수가 있다면 예외 발생")
    void testOutOfRange(String invalidRangeInput) {
        assertThrows(WinningNumberRangeException.class, () -> {
            WinningNumbers.create(invalidRangeInput);
        });
    }

    static Stream<String> invalidRangeValueProvider() {
        return Stream.of(
                "1,2,3,4,5,47",
                "0,20,30,40,42,44",
                "99,80,777,342,123,333"
        );
    }
}