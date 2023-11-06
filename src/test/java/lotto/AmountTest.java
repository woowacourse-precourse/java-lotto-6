package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @DisplayName("구입 금액이 최소 금액 단위 1000원 미만인 경우 에러가 발생한다.")
    @Test
    void createAmountByLessThanMinAmount() {
        assertThatThrownBy(() -> new Amount(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 에러가 발생한다.")
    @Test
    void createAmountByInvalidUnit() {
        assertThatThrownBy(() -> new Amount(1004))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 당첨금액으로 수익률을 계산한다. 이 때 수익률은 소숫점 둘째자리에서 반올림한다.")
    @Test
    void calculateEarningsRateByTotalPrize() {
        Amount amount = new Amount(100000);
        int totalPrize = 62490;

        String result = amount.calculateEarningsRate(62490);
        String expected = "62.5";

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("총 구입금액으로 총 로또구매 개수를 계산한다.")
    @Test
    void calculateTotalLottoNumber() {
        Amount amount = new Amount(10000);

        int result = amount.calculateTotalLottoNumber();
        int expected = 10;

        assertThat(result).isEqualTo(expected);
    }
}
