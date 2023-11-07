package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosGeneratorMachineTest {

    @Test
    @DisplayName("generateLottos()를 통해 로또 객체 생성 확인")
    void testGenerateLottos() {
        //given
        int lottoCount = 1;
        Lottos lottos;
        LottosGeneratorMachine lottosGeneratorMachine = new LottosGeneratorMachine();

        //when
        lottos = new Lottos(lottosGeneratorMachine.generateLottos(lottoCount));

        //then
        Assertions.assertThat(lottos).isInstanceOf(Lottos.class);
        Assertions.assertThat(lottos.getLottos().get(0)).isInstanceOf(Lotto.class);
    }
}