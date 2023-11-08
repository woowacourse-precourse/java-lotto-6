package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또를 발행한다.")
    void createLottos() {
        //given
        Amount amount = new Amount(2_000);
        //when
        Lottos lottos = lottoService.createLottos(amount);
        //then
        Assertions.assertThat(lottos).extracting("lottos")
            .asList()
            .hasSize(amount.getLottoCount());
    }
}