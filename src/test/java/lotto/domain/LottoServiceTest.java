package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {


    @Test
    @DisplayName("구입 금액을 받아서 구매 개수를 반환한다")
    void getPurchaseAmountReturnLottoCount() {
        LottoService lottoService = new LottoService();

        int purchaseAmount = 8000;
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        Assertions.assertThat(lottoCount).isEqualTo(8);
    }

}