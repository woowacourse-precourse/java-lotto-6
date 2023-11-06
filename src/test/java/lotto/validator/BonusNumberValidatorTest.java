package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberValidatorTest {
    Validator bonusNumberValidator = new BonusNumberValidator();
    @DisplayName("보너스 번호로 Null 및 공백 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void testWhenBonusNumberIsNullOrBlank(String bonusNumber) {
        IllegalArgumentException bonusNumberException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> bonusNumberValidator.validate(bonusNumber));
        assertThat(bonusNumberException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("보너스 번호로 숫자가 아닌 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"오", "five", "@"})
    void testWhenBonusNumberIsNotDigit(String bonusNumber) {
        IllegalArgumentException bonusNumberException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> bonusNumberValidator.validate(bonusNumber));
        assertThat(bonusNumberException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("보너스 번호로 범위 밖의 값 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "46", "100"})
    void testWhenBonusNumberIsInvalidRange(String bonusNumber) {
        IllegalArgumentException bonusNumberException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> bonusNumberValidator.validate(bonusNumber));
        assertThat(bonusNumberException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("적절한 보너스 번호 입력 시 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","20","45"})
    void testWhenBonusNumberIsValid(String bonusNumber) {
        Assertions.assertDoesNotThrow(() -> bonusNumberValidator.validate(bonusNumber));
    }
}
