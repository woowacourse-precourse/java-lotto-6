package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void validate_빈문자열받으면_예외를_반환한다() {
        String empty = "";
        assertThatThrownBy(() -> InputValidator.validate(empty))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_null받으면_예외를_반환한다() {
        assertThatThrownBy(() -> InputValidator.validate(null))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", "            "})
    void validate_공백문자열_받으면_예외를_반환한다(String blank) {
        assertThatThrownBy(() -> InputValidator.validate(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8,000", "4,000", "10,000"})
    void validateMoney는_쉼표있는_문자열은_검증_통과한다(String input) {
        // when
        String result = InputValidator.validateMoney(input);
        // then
        assertThat(result).isEqualTo(input.replace(",", ""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"8s000", "'4000s", " "})
    void validateMoney는_정수가아닌_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "100000000"})
    void validateMoney는_최소_최대범위를_벗어난_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8,0", "'40s", " "})
    void validateBonus는_정수가아닌_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void validateBonus는_로또번호_범위를_벗어난_문자열에_예외를_반환한다(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}