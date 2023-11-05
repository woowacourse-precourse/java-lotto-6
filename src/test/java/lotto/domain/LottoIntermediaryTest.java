package lotto.domain;

import org.assertj.core.api.Assertions;
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
    @ValueSource(ints = {1_000, 5_000, 10_000, 100_000})
    void buyLottos(int purchaseAmount) {
        // given & when
        lottoIntermediary.buyLotto(purchaseAmount);
        List<Lotto> lottos = buyer.getLottos();

        // then
        assertThat(lottos).isNotEmpty();
        assertThat(lottos).hasSize(purchaseAmount / Lotto.PRICE);
    }

    @DisplayName("구매 금액이 1,000원 이상이 아닌 경우(1개 이상 구매하지 않는 경우) 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 500, 999})
    void buyLottosFailInvalidPurchasesNumber(int purchaseAmount) {
        // given & when & then
        Assertions.assertThatThrownBy(() -> lottoIntermediary.buyLotto(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1개 이상 구매해야 합니다.");
    }

    @DisplayName("구매 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 1_999, 10_001, 100_001})
    void buyLottosFailInvalidPurchaseAmount(int purchaseAmount) {
        // given & when & then
        Assertions.assertThatThrownBy(() -> lottoIntermediary.buyLotto(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");
    }
}