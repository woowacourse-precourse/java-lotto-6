package lotto.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    @DisplayName("정상적인 구입 금액 입력")
    void 정상적인_구입_금액_입력() throws Exception {
        //given
        String money = "5000";
        //when then
        assertThatCode(() -> InputValidator.validMoneyType(money))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("비정상적인 구입 금액 입력")
    void 비정상적인_구입_금액_입력() throws Exception {
        //given
        String case1 = "5000d";
        String case2 = "abcd";
        String case3 = "!@222";

        //when then
        assertThatThrownBy(() -> InputValidator.validMoneyType(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validMoneyType(case2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validMoneyType(case3))
                .isInstanceOf(IllegalArgumentException.class);
    }


}