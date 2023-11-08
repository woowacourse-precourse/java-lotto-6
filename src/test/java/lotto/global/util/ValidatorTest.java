package lotto.global.util;

import lotto.global.error.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @Test
    void 올바른_가격_값이_주어지면_정상_동작한다() {
        // given
        String price = "8000";

        // when & then
        Validator.validatePrice(price);
    }

    @Test
    void 가격_값이_숫자가_아닌_값으로_주어지면_예외가_발생한다() {
        // given
        String price = "a";

        // when & then
        assertThatThrownBy(() -> Validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PRICE_NOT_INTEGER.getMessage());
    }

    @Test
    void 가격_값의_단위가_1000_단위가_아닌_값이_주어지면_예외가_발생한다() {
        // given
        String price = "2300";

        // when & then
        assertThatThrownBy(() -> Validator.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.PRICE_MISMATCH.getMessage());
    }

    @Test
    void 올바른_당첨_번호_값이_주어지면_정상_동작한다() {
        // given
        String numbers = "1,2,3,4,5,6";

        // when & then
        Validator.validateNumbers(numbers);
    }

    @Test
    void 당첨_번호_값이_공백으로_주어지면_예외가_발생한다() {
        // given
        String numbers = " ";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_IS_BLANK.getMessage());
    }

    @Test
    void 당첨_번호_값이_심볼을_포함하지_않은_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = "123456";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_NOT_CONTAIN_SYMBOL.getMessage());
    }

    @Test
    void 당첨_번호_값에_심볼_위치가_정확하지_않은_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = ",1,3,5,6,7,8,";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_INVALID_SYMBOL_POSITION.getMessage());
    }

    @Test
    void 당첨_번호_값이_6개가_아닌_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = "1,2,3,4,5,6,7";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_INVALID_COUNT.getMessage());
    }

    @Test
    void 허용되지_않은_범위의_당첨_번호_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = "1,2,3,4,5,66";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_INVALID_RANGE.getMessage());
    }

    @Test
    void 당첨_번호_값이_숫자가_아닌_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = "1,2,3,4,5,a";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_NOT_INTEGER.getMessage());
    }

    @Test
    void 당첨_번호_값에_중복된_값이_주어지면_예외가_발생한다() {
        // given
        String numbers = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> Validator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE.getMessage());
    }

    @Test
    void 올바른_보너스_번호_값이_주어지면_정상_동작한다() {
        // given
        String bonusNumber = "7";

        // when & then
        Validator.validateBonusNumber(bonusNumber);
    }

    @Test
    void 보너스_번호_값이_숫자가_아닌_값으로_주어지면_예외가_발생한다() {
        // given
        String bonusNumber = "a";

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_NOT_INTEGER.getMessage());
    }

    @Test
    void 허용되지_않은_범위의_보너스_번호_값이_주어지면_예외가_발생한다() {
        // given
        String bonusNumber = "66";

        // when & then
        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
    }
}