package validators;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import constants.ErrorCodeConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountValidatorTest {

    @DisplayName("구입 금액에 문자가 경우 \"숫자 외의 문자는 입력할 수 없습니다.\" 에러 메세지 반환")
    @Test
    void verifyOnlyNumberAmountTest() {
        // given
        String purchasedAmount = "13가나다500";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(
                        () -> AmountValidator.isVerifyAmount(purchasedAmount))
                .withMessageContaining(ErrorCodeConstant.NUMBER_VALIDATION_ERROR)
                .withNoCause();
    }

    @DisplayName("구입 금액에 문자가 경우 \"금액은 0원 일 수 없습니다.\" 에러 메세지 반환")
    @Test
    void verifyMinNumberAmountTest() {
        // given
        String purchasedAmount = "0";

        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            AmountValidator.isVerifyAmount(purchasedAmount);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCodeConstant.MIN_AMOUNT_ERROR);
    }


    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 \"1,000 단위가 아닙니다.\" 에러 메세지 반환")
    @Test
    void verify1000AmountTest() {
        // given
        String purchasedAmount = "13500";

        //when, then
        assertThatIllegalArgumentException().isThrownBy(
                () -> AmountValidator.isVerifyAmount(purchasedAmount))
                .withMessageContaining(ErrorCodeConstant.THOUSAND_AMOUNT_ERROR)
                .withNoCause();
    }

}
