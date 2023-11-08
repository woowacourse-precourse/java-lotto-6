package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoInitTest {
    @DisplayName("로또 구매 금액이 1000단위로 나누어지지 않으면 에러가 발생해야 한다.")
    @Test
    void checkErrorOccurPurchaseInput() {
        assertThatThrownBy(() -> new LottoInit(1001, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}