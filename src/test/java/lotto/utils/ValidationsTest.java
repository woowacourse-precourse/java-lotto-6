package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationsTest {

    @DisplayName("갯수 및 컴마 구분 테스트")
    @ParameterizedTest
    @MethodSource("providedNumbersCount")
    void testCheckWinningNumbersCount(String numbers) {
        assertThatThrownBy(() -> Validations.checkWinningNumbersCount(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 경우 에러 발생")
    @ParameterizedTest
    @CsvSource({
            "-5",
            "10a",
            "abc"
    })
    void testNumber(String number) {
        assertThatThrownBy(() -> Validations.checkNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액 / 로또가격 이 나누어떨어지지 않는 경우 에러 발생")
    @ParameterizedTest
    @CsvSource({
            "10000, 0",
            "10000, 5300",
            "1000, 150"
    })
    void testDivideByLottoPrice(int givenPrice, int lottoPrice) {
        assertThatThrownBy(() -> Validations.checkDivideByLottoPrice(givenPrice, lottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> providedNumbersCount() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,7,8"),
                Arguments.of("123,4,5,6,7,8"),
                Arguments.of("123_4,5,6,7,8")
        );
    }
}
