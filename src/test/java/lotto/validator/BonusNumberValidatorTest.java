package lotto.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {

    @Test
    void isNumber_정상입력_숫자() {
        assertThat(BonusNumberValidator.isNumber("10")).isEqualTo(true);
    }

    @Test
    void isNumber_비정상입력_문자() {
        assertThatThrownBy(() -> BonusNumberValidator.isNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    void isValidNumber_정상입력_숫자() {
        assertThat(BonusNumberValidator.isValidNumber("10")).isEqualTo(true);
    }

    @Test
    void isValidNumber_비정상입력_문자() {
        assertThatThrownBy(() -> BonusNumberValidator.isValidNumber("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }





}