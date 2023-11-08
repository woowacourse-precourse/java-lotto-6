package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.money.Money;
import lotto.domain.money.Wallet;
import lotto.domain.testutil.FixedLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class LottoSellerTest {
    @DisplayName("buyUntilOutOfMoney는 가진 잔액을 모두 소진할 때까지 로또를 매입한다.")
    @ParameterizedTest
    @ValueSource(longs = {1_000, 10_000, 100_000})
    void buyUntilOutOfMoney_withMoney_shouldSpendAllMoney(final long amount) {
        // given
        final LottoGenerator lottoGenerator = new FixedLottoGenerator(List.of(1, 2, 3, 4, 5, 6));
        final LottoSeller lottoSeller = new LottoSeller(lottoGenerator);
        final Wallet wallet = Wallet.with(amount);

        // when
        final Lottos lottos = lottoSeller.buyUntilOutOfMoney(wallet);

        // then
        assertThat(wallet.hasEqualOrMoreThan(Money.zero())).isTrue();
        assertThat(lottos.size()).isEqualTo(amount / 1_000);
    }

}