package lotto.validator;

import static lotto.Exception.DUPLICATE_BONUS_NUMBER;
import static lotto.validator.BonusNumberValidator.validate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @Test
    void 보너스번호가_당첨_번호와_중복된_경우_예외() {
        int sameNumber = 20;

        assertThatThrownBy(() -> validate(sameNumber, List.of(1, 2, 3, 4, 10, sameNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
