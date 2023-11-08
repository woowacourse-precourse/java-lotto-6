package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.exception.ExceptionMessage.LottoException.BONUS_NUMBER_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberTest {
    @ParameterizedTest
    @MethodSource("invalidRange")
    @DisplayName("보너스 번호의 범위가 1..45 이외라면 예외가 발생한다")
    void throwExceptionByBonusNumberIsNotInRange(final int value) {
        assertThatThrownBy(() -> BonusNumber.create(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_IS_NOT_IN_RANGE.message);
    }

    private static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(46)
        );
    }

    @ParameterizedTest
    @MethodSource("validRange")
    @DisplayName("BonusNumber를 생성한다")
    void success(final int value) {
        assertDoesNotThrow(() -> BonusNumber.create(value));
    }

    private static Stream<Arguments> validRange() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(10),
                Arguments.of(45)
        );
    }
}
