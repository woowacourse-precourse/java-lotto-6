package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_PURCHASE_PRICE;
import static lotto.fixture.PurchaseFixture.비정상;
import static lotto.fixture.PurchaseFixture.한장;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("구매 금액이 개당 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    public void createPurchaseNotMultipleOfLottoPerAmount() throws Exception {
        assertThatThrownBy(() -> 비정상.생성())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_PURCHASE_PRICE.getMessage());
    }

    @DisplayName("구매 금액과 수익금에 대한 수익률을 백분율로 반환한다.")
    @Test
    public void getProfitRate() throws Exception {
        final Purchase purchase = 한장.생성();
        final double actual = purchase.getProfitRate(2000L);
        final double expected = 200.;
        assertThat(actual).isEqualTo(expected);
    }
}