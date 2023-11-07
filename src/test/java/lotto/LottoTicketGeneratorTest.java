package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {
    private LottoTicketGenerator lottoTicketGenerator;

    @BeforeEach
    void initialize() {
        lottoTicketGenerator = new LottoTicketGenerator();
    }

    @DisplayName("구매 수량에 따라 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 15, 60, 100})
    void buyLottoWith(int purchaseQuantity) {

        List<Lotto> lottoTickets = lottoTicketGenerator.buy(purchaseQuantity);

        assertThat(lottoTickets).hasSize(purchaseQuantity);

        assertThat(lottoTickets)
                .doesNotContainNull()
                .allMatch(lotto -> lotto.getNumbers().size() == Lotto.NUMBER_COUNT);
    }
}