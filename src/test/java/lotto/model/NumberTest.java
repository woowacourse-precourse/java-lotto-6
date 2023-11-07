package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidLottoRangeException;
import lotto.exception.NonPositiveIntException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class NumberTest {

    @Test
    void 유효한_숫자_문자열을_입력하면_Number_객체를_반환한다() {
        // given
        String validNumberString = "5";

        // when
        Number number = Number.from(validNumberString);

        // then
        assertThat(number.getValue()).isEqualTo(5);
    }

    @CsvSource({"0","46"})
    @ParameterizedTest
    void 유효하지_않은_숫자_문자열을_입력하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Number.from(input))
                .isInstanceOf(InvalidLottoRangeException.class);
    }

    @CsvSource({"abc","1a"})
    @ParameterizedTest
    void 숫자가_아닌_문자열을_입력하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Number.from(input))
                .isInstanceOf(NonPositiveIntException.class);
    }

    @Test
    void 유효한_숫자를_입력하면_Number_객체를_반환한다() {
        // given
        int validNumber = 7;

        // when
        Number number = Number.from(validNumber);

        // then
        assertThat(number.getValue()).isEqualTo(7);
    }

    @CsvSource({"0","46"})
    @ParameterizedTest
    void 유효하지_않은_숫자를_입력하면_예외가_발생한다(int input) {
        // when & then
        assertThatThrownBy(() -> Number.from(input))
                .isInstanceOf(InvalidLottoRangeException.class);
    }
}
