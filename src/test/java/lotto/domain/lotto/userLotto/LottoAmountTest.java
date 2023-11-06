package lotto.domain.lotto.userLotto;

import lotto.domain.lotto.LottoCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAmountTest {

    @DisplayName("사용자의 로또 개수는 구입 금액을 로또 금액으로 나눈 값이다.")
    @Test
    void crateLottoAmount() {
        int purchasePrice = 3000;

        LottoAmount lottoAmount = new LottoAmount(purchasePrice);

        assertThat(lottoAmount.getLottoAmount()).isEqualTo(purchasePrice/LottoCondition.PRICE.getValue());
    }
}
