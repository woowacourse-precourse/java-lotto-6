package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseTest {
    private LottoPurchase lottoPurchase;

    @BeforeEach
    void setUp() {
        lottoPurchase = new LottoPurchase();
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void lottoPurchaseAmountTest() {
        int purchaseAmount = 5;
        List<Lotto> purchaseLottos = lottoPurchase.purchaseLottoNumbers(purchaseAmount);

        assertThat(purchaseAmount).isEqualTo(purchaseLottos.size());
    }
}
