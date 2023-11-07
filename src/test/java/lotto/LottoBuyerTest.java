package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {

    private LottoBuyer lottoBuyer;

    @BeforeEach
    void setUp() {
        lottoBuyer = new LottoBuyer();
    }

    @Test
    @DisplayName("구입 수량 만큼 로또를 구입한다.")
    void purchaseLottos_AsMuchAsLottoCount() {
        // Given
        final int purchasePrice = 8_000;
        final PurchaseAmount purchaseAmount = new PurchaseAmount(purchasePrice);

        // When
        Lottos result = lottoBuyer.purchaseLottos(purchaseAmount);

        // Then
        assertThat(result.getLottos())
                .isNotEmpty()
                .hasSize(purchaseAmount.getAmount());
    }

}