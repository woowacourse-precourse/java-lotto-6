package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void initialize() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("구매 수량에 따라 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 15, 60, 100})
    void buyLottoWith(int purchaseQuantity) {

        List<Lotto> lottoTickets = lottoGenerator.buy(purchaseQuantity);

        assertThat(lottoTickets).hasSize(purchaseQuantity);

        assertThat(lottoTickets)
                .doesNotContainNull()
                .allMatch(lotto -> lotto.getNumbers().size() == LottoGenerator.NUMBER_COUNT);
    }
}