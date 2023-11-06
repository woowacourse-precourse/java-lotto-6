package lotto.application;

import static lotto.enums.LottoConfig.LOTTO_PRICE;
import static lotto.fixture.LottoFixture.lottoFixture;
import static lotto.fixture.LottoFixture.lottoNumberFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumber;
import lotto.dto.WinningLotto;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    private final LottoMachine lottoMachine = mock(LottoMachine.class);
    private final NumberGenerator numberGenerator = mock(NumberGenerator.class);
    private final LottoStore lottoStore = new LottoStore(lottoMachine, numberGenerator);

    @Test
    void 금액에_맞는_개수만큼_로또를_자동으로_발행한다() {
        // given
        int amount = 8000;
        LottoAmount lottoAmount = new LottoAmount(amount);
        doReturn(lottoFixture()).when(lottoMachine).createLotto(any());

        // when
        List<Lotto> lottos = lottoStore.issueLottoByAuto(lottoAmount);

        // then
        assertThat(lottos).hasSize(amount / LOTTO_PRICE.getValue());
    }

    @Test
    void 당첨_로또와_보너스_번호를_발행한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoFixture = lottoFixture(numbers);
        doReturn(lottoFixture).when(lottoMachine).createLotto(any());
        int bonusNumber = 7;
        LottoNumber bonusFixture = lottoNumberFixture(bonusNumber);
        doReturn(bonusFixture).when(lottoMachine).createLottoNumber(anyInt());

        // when
        WinningLotto winningLotto = lottoStore.issueWinningLotto(numbers, bonusNumber);

        // then
        assertThat(winningLotto.lotto()).isEqualTo(lottoFixture);
        assertThat(winningLotto.bonus()).isEqualTo(bonusFixture);
    }
}