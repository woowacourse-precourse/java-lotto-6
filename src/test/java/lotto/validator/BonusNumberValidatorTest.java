package lotto.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.constants.Constants.BONUS_NOT_NUMBER_MSG;
import static lotto.constants.Constants.BONUS_NOT_VALID_RANGE_MSG;

class BonusNumberValidatorTest {

    @Test
    void isNumber_정상입력_숫자() {
        assertThat(BonusNumberValidator.isNumber("10")).isEqualTo(true);
    }

    @Test
    void isNumber_비정상입력_문자() {
        assertThatThrownBy(() -> BonusNumberValidator.isNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NOT_NUMBER_MSG);
    }

    @Test
    void isValidNumber_정상입력_숫자() {
        assertThat(BonusNumberValidator.isValidNumber("10")).isEqualTo(true);
    }

    @Test
    void isValidNumber_비정상입력_문자() {
        assertThatThrownBy(() -> BonusNumberValidator.isValidNumber("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NOT_VALID_RANGE_MSG);
    }





}