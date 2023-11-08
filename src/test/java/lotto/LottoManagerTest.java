package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoManagerTest {

    @Test
    void purchaseLottosReturnsCorrectNumberOfLottos() {
        LottoManager manager = new LottoManager();
        int purchaseAmount = 5000;
        List<Lotto> lottos = manager.purchaseLottos(purchaseAmount);

        assertThat(lottos).hasSize(5);
    }

    @Test
    void purchaseLottosThrowsExceptionForInvalidAmount() {
        LottoManager manager = new LottoManager();
        int invalidPurchaseAmount = 1500;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> manager.purchaseLottos(invalidPurchaseAmount))
                .withMessageContaining("[ERROR]");
    }

}
