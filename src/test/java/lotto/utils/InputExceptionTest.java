package lotto.utils;

import lotto.domain.PrintMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "22000"})
    @DisplayName("입력이 숫자인지 확인하는 메서드 테스트")
    void isDigitTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isDigit(input);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "thousandwon", "1000won"})
    @DisplayName("입력이 숫자인지 확인하는 메서드 예외처리 테스트")
    void isDigitExceptionTest(String input) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isDigit(input);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_DIGIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 20000})
    @DisplayName("입력이 천원 단위인지 확인하는 메서드 테스트")
    void isThousandUnitTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isThousandUnit(num);
        });

        // then
        assertThat(throwable).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1001, 2020, 23300})
    @DisplayName("입력이 천원 단위인지 확인하는 메서드 예외처리 테스트")
    void isThousandUnitExceptionTest(int num) {
        // when
        Throwable throwable = catchThrowable(() -> {
            InputException.isThousandUnit(num);
        });

        // then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PrintMessage.ONLY_THOUSAND_UNIT);
    }
}