package lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {
    private FixedNumberGenerator fixedNumberGenerator;
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        fixedNumberGenerator = new FixedNumberGenerator(List.of(9, 10, 23, 24, 34, 43));
        lottoStore = new LottoStore(fixedNumberGenerator);
    }

    @DisplayName("sellLottoTickets는 구입 금액만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 10_000, 100_000})
    void should_Issue_Lotto_Tickets(int purchaseAmount) {
        // given
        Money money = Money.fromInitialMoney(purchaseAmount);

        // when
        Lottos lottoTickets = lottoStore.sellLottoTickets(money);

        // then
        assertThat(lottoTickets.getLottos().size()).isEqualTo(purchaseAmount / 1_000);
    }

    @DisplayName("구입 금액이 부족하면 로또를 판매할 수 없다.")
    @Test
    void should_throw_Exception_When_Not_Enough_Money() {
        // given
        Money money = Money.fromRemainingMoney(0);

        // when
        // then
        assertThatThrownBy(() -> lottoStore.sellLottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}