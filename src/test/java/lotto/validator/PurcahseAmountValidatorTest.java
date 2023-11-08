package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static lotto.constants.Constants.PURCHASE_NOT_NUMBER_MSG;
import static lotto.constants.Constants.PURCHASE_NOT_POSITIVE_MSG;
import static lotto.constants.Constants.PURCHASE_NOT_THOUSANDS_MSG;

class PurcahseAmountValidatorTest {

    @Test
    void isNumber_정상입력_숫자() {
        assertThat(PurcahseAmountValidator.isNumber("1")).isEqualTo(true);
    }

    @Test
    void isNumber_비정상입력_문자() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_NOT_NUMBER_MSG);
    }

    @Test
    void isPositive_정상입력_양수() {
        assertThat(PurcahseAmountValidator.isPositive("10")).isEqualTo(true);
    }

    @Test
    void isPositive_비정상입력_음수() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isPositive("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_NOT_POSITIVE_MSG);
    }

    @Test
    void isThousands_정상입력_천의배수() {
        assertThat(PurcahseAmountValidator.isThousands("3000")).isEqualTo(true);
    }

    @Test
    void isThousands_비정상입력() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isThousands("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_NOT_THOUSANDS_MSG);
    }
}