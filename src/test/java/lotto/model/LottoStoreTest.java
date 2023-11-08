package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @DisplayName("로또 10장 판매한 경우")
    @Test
    void sellTenLottos() {
        LottoStore lottoStore = new LottoStore();

        int lottoCount = 10;
        List<Lotto> lottos = lottoStore.sell(lottoCount);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @DisplayName("로또 0장 판매한 경우")
    @Test
    void sellNone() {
        LottoStore lottoStore = new LottoStore();

        int lottoCount = 0;
        List<Lotto> lottos = lottoStore.sell(lottoCount);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}
