package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {
    BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void beforeEach() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    @DisplayName("1 ~ 45 내의 숫자라면 어떠한 Exception도 감지되지 않는다.")
    void bonusNumberIsInRangeTest(Integer bonusNumber) {
        // given
        // when & then
        assertThatNoException().isThrownBy(() -> bonusNumberValidator.checkInRange(bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("convertedOutOfRangeBonusNumber")
    @DisplayName("1 ~ 45 내의 숫자가 아니라면 IllegalArgumentException을 반환한다.")
    void bonusNumberOutOfRangeTest(Integer bonusNumber, String expectedExceptionMessage) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bonusNumberValidator.checkInRange(bonusNumber))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> convertedOutOfRangeBonusNumber() {
        return Stream.of(
                Arguments.of(-1, SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage()),
                Arguments.of(0, SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage()),
                Arguments.of(46, BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage())
        );
    }

    @ParameterizedTest
    @MethodSource("convertedNotDuplicateBonusNumber")
    @DisplayName("당첨 번호와 중복되지 않은 보너스 번호가 입력될 경우 어떠한 Exception도 감지되지 않는다.")
    void notDuplicateWithWinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        // given
        // when & then
        assertThatNoException().isThrownBy(
                () -> bonusNumberValidator.checkDuplicateWithWinningNumbers(winningNumbers, bonusNumber));
    }

    static Stream<Arguments> convertedNotDuplicateBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), 39)
        );
    }

    @ParameterizedTest
    @MethodSource("convertedDuplicateBonusNumber")
    @DisplayName("당첨 번호와 중복된 보너스 번호가 입력될 경우 IllegalArgumentException을 반환한다.")
    void duplicateWithWinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        // given
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> bonusNumberValidator.checkDuplicateWithWinningNumbers(winningNumbers, bonusNumber))
                .withMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    static Stream<Arguments> convertedDuplicateBonusNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(Arrays.asList(45, 44, 43, 42, 41, 40), 40)
        );
    }
}