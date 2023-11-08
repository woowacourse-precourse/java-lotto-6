package lotto;

import lotto.domain.BuyingLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyingLottoTest {
    @DisplayName("로또 구입금액이 0 또는 음수이면 예외가 발생한다.")
    @Test
    void createBuyingPriceByNotPlusSign() {
        assertThatThrownBy(() -> new BuyingLotto(-100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createBuyingPriceByNotUnitOf1000() {
        assertThatThrownBy(() -> new BuyingLotto(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액으로 발행할 수 있는 로또의 수를 알맞게 리턴한다.")
    @Test
    void testCalculateTicketNumber() {
        int buyingPrice = 15000;
        int result = new BuyingLotto(buyingPrice).getTicketNumber();
        int answer = 15;

        assertThat(result).isEqualTo(answer);
    }
}
