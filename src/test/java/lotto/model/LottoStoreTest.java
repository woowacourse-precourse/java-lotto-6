package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @Test
    void sell_로또_10장_판매한_경우() {
        LottoStore lottoStore = new LottoStore();

        int lottoCount = 10;
        List<Lotto> lottos = lottoStore.sell(lottoCount);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @Test
    void sell_로또_0장_판매한_경우() {
        LottoStore lottoStore = new LottoStore();

        int lottoCount = 0;
        List<Lotto> lottos = lottoStore.sell(lottoCount);

        Assertions.assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}
