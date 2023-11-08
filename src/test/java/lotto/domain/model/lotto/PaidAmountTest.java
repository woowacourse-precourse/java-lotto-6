package lotto.domain.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PaidAmountTest {

    @DisplayName("지불금액이 0일때, 로또 가격으로 나누어떨어지지 않을 때 에러")
    @ParameterizedTest
    @CsvSource({"0, ZERO_PAID_AMOUNT",
            "1001, NOT_DIVISIBLE_PAID_AMOUNT"})
    void createPaidAmountFail(int paid, ErrorMessage errorMessage) {
        assertThatThrownBy(() -> new PaidAmount(paid))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage.getMessage());
    }

    @DisplayName("지불금액을 알맞게 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000})
    void createPaidAmountSuccessfully(int paid) {
        PaidAmount paidAmount = new PaidAmount(paid);

        assertThat(paidAmount.getPaidAmount())
                .isEqualTo(paid);
    }
}