package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {
    @Test
    @DisplayName("금액에 맞춰 1000원당 로또를 하나씩 발행 해준다.")
    void sellLottosAccordingToMoney() {
        Integer money = 10000;
        Store store = new Store();
        List<Lotto> lottos = store.sellLottos(money);
        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }
}