package lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {
    @DisplayName("sellLottoTickets는 구입 금액만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 10_000, 100_000})
    void should_Issue_Lotto_Tickets(int purchaseAmount) {
        // given
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(9, 10, 23, 24, 34, 43));
        LottoStore lottoStore = new LottoStore(fixedNumberGenerator);
        Money money = Money.fromInitialMoney(purchaseAmount);

        // when
        Lottos lottoTickets = lottoStore.sellLottoTickets(money);

        // then
        assertThat(lottoTickets.getLottos().size()).isEqualTo(purchaseAmount / 1_000);
    }
}