package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountValidatorTest {

    @Test
    @DisplayName("금액이 정수가 이닐 경우 예외를 발생시킨다.")
    void throwExceptionAmountNotDigit() {
        //given
        String amount = "amount";
        //when //then
        assertThatThrownBy(() -> AmountValidator.validateAmount(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입 금액은 정수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("금액이 정수일 경우 예외를 발생시키지 않는다.")
    void notThrowExceptionAmountDigit() {
        //given
        String amount = "1000";
        //when //then
        assertThatCode(() -> AmountValidator.validateAmount(amount))
            .doesNotThrowAnyException();
    }
}