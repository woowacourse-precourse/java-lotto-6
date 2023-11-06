package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_PRICE;
import static lotto.fixture.LottoFixture.lottoFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
    void 금액에_맞는_개수만큼_로또를_자동으로_발행한다() {
        // given
        int amount = 8000;
        LottoAmount lottoAmount = new LottoAmount(amount);
        doReturn(lottoFixture()).when(lottoMachine).createLottoByAuto();

        // when
        List<Lotto> lottos = lottoStore.issueLottoByAuto(lottoAmount);

        // then
        assertThat(lottos).hasSize(amount / LOTTO_PRICE.getValue());
    }

    @Test
    void 당첨_로또를_발행한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoFixture = lottoFixture(numbers);
        doReturn(lottoFixture).when(lottoMachine).createLottoByManual(any());

        // when
        Lotto lotto = lottoStore.issueWinningLotto(numbers);

        // then
        assertThat(lotto).isEqualTo(lottoFixture);
    }
}