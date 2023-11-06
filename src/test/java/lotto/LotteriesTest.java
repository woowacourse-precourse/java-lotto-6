package lotto;

import static lotto.LottoConstants.LOTTO_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    @DisplayName("로또 구매 가격에 맞는 개수의 로또를 구매한다.")
    @Test
    void purchaseLotteries() {
        // given
        int purchaseAmount = 5000;

        // when
        Lotteries lotteries = new Lotteries(purchaseAmount);

        // then
        assertThat(lotteries.getLotteries().size()).isEqualTo(purchaseAmount / LOTTO_TICKET_PRICE);
    }
}
