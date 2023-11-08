package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {
    LottoService lottoService = LottoServiceImpl.getInstance();

    @DisplayName("구입 금액만큼 로또 구매하기")
    @Test
    void testBuyLottos() {
        assertThat(lottoService.buyLottos("3000").getLottos().size())
                .isEqualTo(3);
    }
}