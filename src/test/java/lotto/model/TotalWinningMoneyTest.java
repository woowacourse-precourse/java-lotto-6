package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class TotalWinningMoneyTest {

    @Test
    void 총_당첨금은_음수값을_가질_수_없다() {
        assertThatThrownBy(() -> TotalWinningMoney.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_당첨금은_0원_이상이어야_한다() {
        assertDoesNotThrow(
                () -> TotalWinningMoney.from(0)
        );
    }

    @Test
    void 총_당첨금을_구매금액으로_나누면_수익률을_구할_수_있다() {
        TotalWinningMoney totalWinningMoney = TotalWinningMoney.from(5_000);
        int money = 1000;

        BigDecimal actualReturnOnInvestment = totalWinningMoney.calculateReturnOnInvestment(money);

        BigDecimal expectedReturnOnInvestment = BigDecimal.valueOf(5);
        assertThat(actualReturnOnInvestment).isEqualTo(expectedReturnOnInvestment);
    }

    @Test
    void 총_당첨금이_같다면_서로_같은_객체이다() {
        TotalWinningMoney totalWinningMoney = TotalWinningMoney.from(5_000);
        TotalWinningMoney anotherTotalWinningMoney = TotalWinningMoney.from(5_000);

        assertThat(totalWinningMoney).isEqualTo(anotherTotalWinningMoney);
    }

    @Test
    void 총_당첨금이_다르다면_서로_다른_객체이다() {
        TotalWinningMoney totalWinningMoney = TotalWinningMoney.from(5_000);
        TotalWinningMoney anotherTotalWinningMoney = TotalWinningMoney.from(10_000);

        assertThat(totalWinningMoney).isNotEqualTo(anotherTotalWinningMoney);
    }

    @Test
    void 총_당첨금이_같다면_서로_같은_해시코드를_가진다() {
        TotalWinningMoney totalWinningMoney = TotalWinningMoney.from(5_000);
        TotalWinningMoney anotherTotalWinningMoney = TotalWinningMoney.from(5_000);

        assertThat(totalWinningMoney).hasSameHashCodeAs(anotherTotalWinningMoney);
    }
}
