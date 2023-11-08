package lotto.validator;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.message.ErrorMessage.*;

class BonusNumberValidatorTest {

    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumbers);

    @Test
    void 보너스번호_검증_성공() {
        String input = "23";
        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatCode(() -> validator.validate(input, lotto)).doesNotThrowAnyException();

    }

    @Test
    void 보너스번호가_숫자인지_검증() {
        String input = "aaa";

        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input, lotto)).
                withMessage(BONUS_NUMBER_IS_NOT_NUMERIC_MESSAGE.getMessage());
    }

    @Test
    void 보너스번호가_범위를_초과_검증() {
        String input1 = "0";
        String input2 = "46";

        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input1, lotto)).
                withMessage(BONUS_NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());
        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input2, lotto)).
                withMessage(BONUS_NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());

    }

    @Test
    void 보너스번호가_당첨번호와_중복되는지_검증() {
        String input = "1";

        BonusNumberValidator validator = new BonusNumberValidator();

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input, lotto)).
                withMessage(BONUS_NUMBER_IS_DUPLICATED_BY_LOTTO_NUMBER.getMessage());
    }

}