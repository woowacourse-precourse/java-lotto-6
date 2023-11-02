package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @DisplayName("발행된 로또 수가 맞는지 확인")
    @Test
    void checkCorrectPublishLotto() {
        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        buyer.buyLotto("11000");

        manager.publishLotto();

        assertThat(buyer.getMyLotts().size()).isEqualTo(11);
    }
}
