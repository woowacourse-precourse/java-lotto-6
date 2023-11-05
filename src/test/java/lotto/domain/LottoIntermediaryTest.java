package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIntermediaryTest {

    Buyer buyer;
    LottoIntermediary lottoIntermediary;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
        lottoIntermediary = new LottoIntermediary(buyer);
    }

    @DisplayName("사용자가 입력한 구매 금액에 맞는 개수만큼 로또를 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000, 100000})
    void buyLottos(int purchaseAmount) {
        // given & when
        lottoIntermediary.buyLotto(purchaseAmount);
        List<Lotto> lottos = buyer.getLottos();

        // then
        assertThat(lottos).isNotEmpty();
        assertThat(lottos).hasSize(purchaseAmount / 1_000);
    }
}