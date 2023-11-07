package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.validator.ErrorMessage.*;

class LottoNumberValidatorTest {

    LottoNumberValidator validator = new LottoNumberValidator();

    @Test
    void 로또_번호_성공() {
        String input = "1,2,3,4,5,6";
        Assertions.assertThatCode(() -> validator.validate(input)).doesNotThrowAnyException();
    }

    @Test
    void 입력된_로또번호가_숫자인지_검증() {
        String input = "asd,asd,asd,asd,asd";
        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input)).
                withMessage(LOTTO_NUMBERS_ARE_NOT_NUMERIC_MESSAGE);
    }

    @Test
    void 입력된_로또번호의_갯수_검증() {
        String input1 = "1,2,3,4,5";
        String input2 = "1,2,3,4,5,6,7";

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input1)).
                withMessage(LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE);

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input2)).
                withMessage(LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE);
    }

    @Test
    void 각_로또_번호가_올바른_범위인지_검증() {
        String input1 = "0,1,2,3,4,5";
        String input2 = "1,2,3,4,5,46";

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input1)).
                withMessage(LOTTO_NUMBERS_ARE_NOT_IN_RANGE_MESSAGE);

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input2)).
                withMessage(LOTTO_NUMBERS_ARE_NOT_IN_RANGE_MESSAGE);
    }

    @Test
    void
    로또번호가_중복되지_않았는지_검증() {
        String input="1,2,2,3,4,5";

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input)).
                withMessage(LOTTO_NUMBERS_ARE_DUPLICATED_MESSAGE);


    }


}