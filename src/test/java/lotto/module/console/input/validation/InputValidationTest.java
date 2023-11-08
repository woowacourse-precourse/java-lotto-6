package lotto.module.console.input.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputValidationTest {

    private final InputValidation inputValidation = InputValidation.newInstance();

    @Test
    void 숫자_외에_값_입력시_익셉션_발생_테스트() {
        // given
        String nonNumericString = "r";

        // when
        // then
        assertThatThrownBy(() -> inputValidation.validatePurchaseAmount(nonNumericString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_값_입력시_익셉션_미발생_테스트() {
        // given
        String numericString = "11";

        // when
        // then
        assertThatCode(() -> inputValidation.validatePurchaseAmount(numericString))
                .doesNotThrowAnyException();
    }

    @Test
    void 최대_구매금_값_입력시_익셉션_발생_테스트() {
        // given
        String nonNumericString = "1000000000";

        // when
        // then
        assertThatThrownBy(() -> inputValidation.validatePurchaseAmount(nonNumericString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위외에_값_익셉션_발생_테스트() {
        // given
        String outOfRangeString = "46";

        // when
        // then
        assertThatThrownBy(() -> inputValidation.validateLottoNumbersRange(outOfRangeString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위안에_값_익셉션_발생_테스트() {
        // given
        String withinRangeString = "35";

        // when
        // then
        assertThatCode(() -> inputValidation.validateLottoNumbersRange(withinRangeString))
                .doesNotThrowAnyException();
    }

}