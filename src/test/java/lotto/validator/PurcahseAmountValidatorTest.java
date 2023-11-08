package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurcahseAmountValidatorTest {

    @Test
    void isNumber_정상입력_숫자() {
        assertThat(PurcahseAmountValidator.isNumber("1")).isEqualTo(true);
    }

    @Test
    void isNumber_비정상입력_문자() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 숫자여야 합니다.");
    }

    @Test
    void isPositive_정상입력_양수() {
        assertThat(PurcahseAmountValidator.isPositive("10")).isEqualTo(true);
    }

    @Test
    void isPositive_비정상입력_음수() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isPositive("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 0이상의 숫자여야 합니다.");
    }

    @Test
    void isThousands_정상입력_천의배수() {
        assertThat(PurcahseAmountValidator.isThousands("3000")).isEqualTo(true);
    }

    @Test
    void isThousands_비정상입력() {
        assertThatThrownBy(() -> PurcahseAmountValidator.isThousands("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 1000의 배수여야 합니다.");
    }
}