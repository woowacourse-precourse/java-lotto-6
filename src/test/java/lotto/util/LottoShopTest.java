package lotto.util;

import lotto.domain.lotto.Lottos;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoShopTest {

    @Test
    @DisplayName("금액에 맞게 로또를 여러개 구입할 수 있다.")
    public void buyLottos() {
        // given
        long amount = 10000;
        // when
        Lottos lottos = LottoShop.buyLottos(amount);
        // then
        assertThat(lottos.getLottos()).hasSize((int) amount / 1000);
    }

    @Test
    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    public void buyLottosException() {
        // given
        long amount = 1200;
        // when // then
        assertThatThrownBy(() -> LottoShop.buyLottos(amount))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
    }

}