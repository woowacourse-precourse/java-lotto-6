package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

    @DisplayName("구매 금액에 맞는 로또 수량을 발행하는지 테스트")
    @Test
    void createLottoCount() {
        int amount = 10000;
        LottoCount lottoCount = LottoCount.createLottoCount(amount);
        assertThat(lottoCount.getLottoCount()).isEqualTo(10);
    }

    @DisplayName("구매 금액이 올바르지 않은 경우 수량 예외 발생 테스트")
    @Test
    void isDivisible() {
        int amount = 10001;
        assertThatThrownBy(() -> LottoCount.createLottoCount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_ONE_TICKET_PRICE.get());
    }

    @DisplayName("최소 구매 금액보다 적은 경우 수량 예외 발생 테스트")
    @Test
    void isMinAmount() {
        int amount = 500;
        assertThatThrownBy(() -> LottoCount.createLottoCount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_MIN_TICKET_PRICE.get());
    }

}