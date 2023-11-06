package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {
    @Test
    @DisplayName("로또 구입 금액은 0이 아니여야 한다.")
    void zeroLottoMoney() {
        // given
        Money requestMoney = new Money(0);
        LottoMoney lottoMoney = new LottoMoney();

        // when & then
        assertThatThrownBy(() -> lottoMoney.getTicketCount(requestMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액에 따라 구입 갯수를 반환한다.")
    void getTicketCount() {
        // given
        Money requestMoney = new Money(2000);
        LottoMoney lottoMoney = new LottoMoney();

        // when
        int ticketCount = lottoMoney.getTicketCount(requestMoney);

        // then
        Assertions.assertEquals(2, ticketCount);
    }
}