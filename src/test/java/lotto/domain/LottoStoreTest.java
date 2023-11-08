package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.exception.DomainExceptionCode;
import lotto.domain.strategy.RandomLottoPublisher;
import lotto.domain.strategy.RandomNumbersGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoStoreTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 999, 1111, 11111, 11111111})
    void 로또를_구입할_때_1000원_단위로_구매_가능합니다(final int input) {
        final var lottoStore = new LottoStore(new RandomLottoPublisher(new RandomNumbersGenerator()));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoStore.purchaseLotto(new Money(input)))
                .withMessageContaining(DomainExceptionCode.LOTTO_PAYMENT_PRICE_REQUIRED.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000, 10000})
    void 지정한_개수_만큼_로또를_만들어_냅니다(long quantity) {
        final var lottoStore = new LottoStore(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        final var purchasedLottoBundle = lottoStore.purchaseLotto(new Money(quantity * 1000));

        assertThat(purchasedLottoBundle.getQuantity()).isEqualTo(quantity);
    }

}
