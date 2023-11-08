package lotto.util;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.message.ErrorMessage.INVALID_LOTTO_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    @Test
    @DisplayName("로또 금액이 1000원일 때 금액에 맞게 로또를 여러개 구입할 수 있다.")
    public void buyLottos() {
        // given
        int requestCash = 10000;
        Cash cash = new Cash(requestCash);
        // when
        Lottos lottos = LottoShop.buyLottos(cash);
        // then
        assertThat(lottos.getLottos()).hasSize(requestCash / 1000);
    }

    @Test
    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    public void buyLottosException() {
        // given
        long requestCash = 1200;
        Cash cash = new Cash(requestCash);
        // when // then
        assertThatThrownBy(() -> LottoShop.buyLottos(cash))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_MONEY.getMessage());
    }

}