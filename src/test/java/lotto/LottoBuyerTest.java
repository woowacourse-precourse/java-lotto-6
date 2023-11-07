package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.io.ConsoleManager;
import lotto.vo.PurchaseAmount;
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
    @DisplayName("구입 금액으로 로또 구입 개수를 구한다.")
    void getLottoCount_LottoPrice() {
        // Given
        final int purchasePrice = 8_000;

        // When
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchasePrice);

        // Then
        assertThat(purchaseAmount.getAmount()).isEqualTo(purchasePrice / 1_000);
    }

    @Test
    @DisplayName("구입 수량 만큼 로또를 구입한다.")
    void purchaseLottos_AsMuchAsLottoCount() {
        // Given
        final int lottoCount = 3;

        // When
        List<Lotto> result = lottoBuyer.purchaseLottos(lottoCount);

        // Then
        assertThat(result)
                .isNotEmpty()
                .hasSize(lottoCount);
    }

}