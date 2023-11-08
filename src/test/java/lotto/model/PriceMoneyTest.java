package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceMoneyTest {
    @DisplayName("상금이 음수가 될 경우 예외 발생")
    @Test
    void createPriceMoneyWithNegative() {
        assertThatThrownBy(
                () -> new PriceMoney(-100)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상금에 음수를 곱하는 경우 예외 발생")
    @Test
    void multiplyByNegativeValue() {
        // given
        PriceMoney priceMoney = new PriceMoney(1000);

        // when, then
        assertThatThrownBy(
                () -> priceMoney.mulByEa(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상금 덧셈 검사")
    @Test
    void addPriceMoneyTest() {
        // given
        PriceMoney priceMoney = new PriceMoney(1000);
        PriceMoney addMoney = new PriceMoney(2000);

        PriceMoney result = new PriceMoney(3000);

        // when, then
        assertThat(priceMoney.add(addMoney)).isEqualTo(result);
    }

    @DisplayName("로또 티켓 가격과 나눗셈 검사 1 - 현재 상금이 0일 경우")
    @Test
    void testIncomeRateIfZero() {
        // given
        PriceMoney priceMoney = new PriceMoney(0);
        LottoTicketMoney lottoTicketMoney = new LottoTicketMoney(1000);

        // when, then
        assertThat(priceMoney.div(lottoTicketMoney)).isEqualTo(0);
    }

    @DisplayName("로또 티켓 가격과 나눗셈 검사 2 - 현재 상금이 0이 아닐 경우")
    @Test
    void testIncomeRate() {
        // given
        PriceMoney priceMoney = new PriceMoney(5000);
        LottoTicketMoney lottoTicketMoney = new LottoTicketMoney(10000);

        // when, then
        assertThat(priceMoney.div(lottoTicketMoney)).isEqualTo(5000 / (double) 10000);
        // further question: Double 타입 데이터 끼리 비교하는데도 통과하는 이유는?
    }
}
