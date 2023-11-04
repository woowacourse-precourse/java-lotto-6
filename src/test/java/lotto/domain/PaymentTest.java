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
    @DisplayName("구입 금액 예외 처리: 1,000원 이하인 경우")
    void givenUnderThousand_whenCreatePayment_thenThrowException(String amount) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Payment(amount))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("최소 구입 금액은 1,000원 입니다.");
    }

    @Test
    @DisplayName("구입 금액 생성 성공")
    void givenThousand_whenCreatePayment_thenNoException() {
        // given
        String amount = "1000";

        // when & then
        assertThatNoException()
                .isThrownBy(() -> new Payment(amount));
    }

}
