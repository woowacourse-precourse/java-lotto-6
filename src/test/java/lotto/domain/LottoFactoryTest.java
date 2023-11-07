package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoFactoryTest {

    @Test
    public void 구입금액을_입력받아_로또를_랜덤으로_생성한다() throws Exception {
        //given
        int price = 10000;

        //when
        List<Lotto> lottos = LottoFactory.buyLotto(10000);

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }
}