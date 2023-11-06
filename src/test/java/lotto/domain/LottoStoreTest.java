package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
                .isThrownBy(() -> lottoStore.purchaseLotto(new Money(input)));
    }

}