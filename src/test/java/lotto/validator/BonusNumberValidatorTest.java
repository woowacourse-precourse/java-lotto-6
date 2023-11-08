package lotto.validator;

import static lotto.exception.Exception.DUPLICATE_BONUS_NUMBER;
import static lotto.validator.BonusNumberValidator.validate;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @DisplayName("보너스번호가 당첨 번호와 중복된 경우 예외가 발생하는가.")
    @Test
    void validateBonusByDuplication() {
        int sameNumber = 20;

        assertThatThrownBy(() -> validate(sameNumber, List.of(1, 2, 3, 4, 10, sameNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
