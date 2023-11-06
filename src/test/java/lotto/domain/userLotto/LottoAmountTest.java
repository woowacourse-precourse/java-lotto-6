package lotto.domain.userLotto;

import lotto.domain.LottoCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAmountTest {

    @Test
    @DisplayName("구매 금액을 1000으로 나눈 값이 로또 구매 개수")
    void When_DivisibleByLottoPrice_Expect_LottoAmountIsPurchasePriceDividedByLottoPrice() {
        // given
        int purchasePrice = 3000;

        // when
        LottoAmount lottoAmount = new LottoAmount(purchasePrice);

        // then
        assertThat(lottoAmount.getLottoAmount()).isEqualTo(purchasePrice/LottoCondition.PRICE.getValue());
    }
}
