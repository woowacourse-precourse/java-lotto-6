package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_BONUS_CHARACTER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BonusNumberValidator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BonusNumberValidatorTest {
    private static final BonusNumberValidator validator = new BonusNumberValidator();

    @ParameterizedTest
    @ValueSource(strings = {"1a928", "1 23", "1:23", "1,000", ",1230"})
    void 숫자가_포함되지_않은_입력값에_예외를_발생한다(String input) {
        assertThatThrownBy(() -> validator.valid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_BONUS_CHARACTER_ERROR_MESSAGE.getMessage());
    }
}
