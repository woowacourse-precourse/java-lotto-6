package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoMachineTest {

    @Test
    void 만원으로는_10장의_로또를_살수있다(){
        //given
        LottoMachine lottoMachine = LottoMachine.getInstance();
        //when
        List<Lotto> lottos = lottoMachine.produceLottos(10000);
        //then
        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }

}