package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoPurchaseManagerTest {

    @Test
    void calculateNumOfLotto() {
        LottoPurchaseManager manager = new LottoPurchaseManager();
        int numOfLotto = manager.calculateNumOfLotto(7000);
        assertThat(numOfLotto).isEqualTo(7);
    }

    @Test
    void receiveNotMultipleOfThousand() {
        LottoPurchaseManager manager = new LottoPurchaseManager();
        assertThatThrownBy(() -> manager.calculateNumOfLotto(7300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 " + manager.PRICE_OF_LOTTO + "원으로 나누어 떨어져야 합니다.");
    }
}