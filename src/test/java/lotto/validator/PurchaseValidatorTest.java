package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Constants;

class PurchaseValidatorTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1000,", " 1000", "1000 ", "101,000"})
    @DisplayName("구입 금액 예외 처리: 구입 금액에 숫자외 다른 문자가 있는 경우")
    void givenNonPositiveNumber_whenValidateOnlyNumberExist_thenThrowException(String amount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseValidator.validate(amount))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("구입 금액은 숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"0", "100", "999"})
    @DisplayName("구입 금액 예외 처리: 최소 금액 1,000원 미만인 경우")
    void givenUnderThousand_whenValidateMinAmount_thenThrowException(String amount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseValidator.validate(amount))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("최소 구입 금액은 1,000원 입니다.");
    }

    @Test
    @DisplayName("구입 금액 예외 처리: 1,000원 단위가 아닌 경우")
    void givenNotThousandUnit_whenValidateThousandUnit_thenThrowException() {
        // given
        String amount = "10100";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseValidator.validate(amount))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("구입 금액은 1,000원 단위 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"2000001000", "200000100000000000"})
    @DisplayName("구입 금액 예외 처리: 최대 금액 2,000,000,000원을 초과한 경우")
    void givenOverTwoBillion_whenValidateMaxAmount_thenThrowException(String amount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseValidator.validate(amount))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("최대 구입 금액은 2,000,000,000원 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1000", "2000000000"})
    @DisplayName("구입 금액 예외 처리 통과")
    void givenAmount_whenValidate_thenNoException(String amount) {
        // when & then
        assertThatNoException()
                .isThrownBy(() -> PurchaseValidator.validate(amount));
    }

}
