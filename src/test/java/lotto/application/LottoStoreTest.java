package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_PRICE;
import static lotto.fixture.LottoFixture.lottoFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    private final LottoMachine lottoMachine = mock(LottoMachine.class);
    private final LottoStore lottoStore = new LottoStore(lottoMachine);

    @Test
    void 금액에_맞게_로또를_발행한다() {
        // given
        int amount = 8000;
        LottoAmount lottoAmount = new LottoAmount(amount);
        doReturn(lottoFixture()).when(lottoMachine).createLottoByAuto();

        // when
        List<Lotto> lottos = lottoStore.issueLotto(lottoAmount);

        // then
        assertThat(lottos).hasSize(amount / LOTTO_PRICE.getValue());
    }

}