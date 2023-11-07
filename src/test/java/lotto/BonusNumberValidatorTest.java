package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.domain.validator.BonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberValidatorTest {
    public static BonusNumberValidator bonusNumberValidator;
    private static Stream<Arguments> testStringForValidateNumeric() {
        return Stream.of(
                arguments("    1"),
                arguments("하나"),
                arguments("1a")
        );
    }
    @BeforeEach
    public void setUp() {bonusNumberValidator= new BonusNumberValidator();}

    @DisplayName("입력한 보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("testStringForValidateNumeric")
    public void testValidateNumeric(String testString) {
        assertThatThrownBy(() -> bonusNumberValidator.validateNumeric(testString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 보너스 번호가  1~45 범위 외의 값을 가지면 예외가 발생한다.")
    @Test
    public void testValidateRange() {
        assertThatThrownBy(() -> bonusNumberValidator.validateRange("56"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
