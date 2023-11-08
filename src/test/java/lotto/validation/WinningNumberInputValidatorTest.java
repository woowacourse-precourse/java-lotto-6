package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberInputValidatorTest {

    WinningNumberInputValidator winningNumberInputValidator = new WinningNumberInputValidator();

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6', true", "'1,2,3,4,5', false"})
    @DisplayName("쉼표 5개 여부 테스트")
    void 쉼표_5개_여부_테스트(String winningNumber, boolean expected) {
        Assertions.assertThat(winningNumberInputValidator.isCommaFive(winningNumber)).isEqualTo(expected);
    }
}