package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"0", "100", "999"})
    @DisplayName("구입 금액 예외 처리: 최소 금액 1,000원 미만인 경우")
    void givenUnderThousand_whenCreatePayment_thenThrowException(String amount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(amount))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("최소 구입 금액은 1,000원 입니다.");
    }

    @Test
    @DisplayName("구입 금액 예외 처리: 1,000원 단위가 아닌 경우")
    void givenNotThousandUnit_whenCreatePayment_thenThrowException() {
        // given
        String amount = "10100";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(amount))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("구입 금액은 1,000원 단위 입니다.");
    }

    @Test
    @DisplayName("구입 금액 예외 처리: 최대 금액 2,000,000,000원을 초과한 경우")
    void givenOverTwoBillion_whenCreatePayment_thenThrowException() {
        // given
        String amount = "2000001000";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(amount))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("최대 구입 금액은 2,000,000,000원 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1000", "2000000000"})
    @DisplayName("구입 금액 생성 성공")
    void givenAmount_whenCreatePayment_thenNoException(String amount) {
        // when & then
        assertThatNoException()
                .isThrownBy(() -> new Payment(amount));
    }

}
