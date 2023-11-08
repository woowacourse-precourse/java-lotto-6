package lotto.domain;

import lotto.constants.message.ErrorMessage;
import lotto.domain.lotto.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 구매 금액 객체에 대해")
class PurchasePriceTest {

    private static final String error = ErrorMessage.ERROR_TAG.toString();

    @Test
    @DisplayName("구매 금액이 1000 단위가 아니라면 에러가 발생한다.")
    void When_PurchasePriceIsNotThousandUnit_Then_Error() {
        assertThatThrownBy(() -> PurchasePrice.from(1009))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error);
    }

    @Test
    @DisplayName("구매 금액이 1000단위라면 정상적이다.")
    void When_PurchasePriceIsThousandUnit_Then_Correct() {
        assertThatCode(() -> PurchasePrice.from(5000))
                .doesNotThrowAnyException();
    }
}
