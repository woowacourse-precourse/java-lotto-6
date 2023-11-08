package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    void sellLottos_메서드는_입력받은_금액만큼_로또를_발행한다() {
        //given
        LottoStore lottoStore = new LottoStore();
        //when
        List<Lotto> lottos = lottoStore.sellLottos(8000);
        //then
        assertThat(lottos.size()).isEqualTo(8);
    }
}
