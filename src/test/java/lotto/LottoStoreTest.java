package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @Test
    @DisplayName("1000원에 1개씩의 로또를 구매한다.")
    void buyLottos() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(8000);

        Assertions.assertThat(lottos.size()).isEqualTo(8);
    }
}
