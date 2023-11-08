package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("주어진 개수만큼 로또를 발행한다.")
    @Test
    void 로또_발행_기능() {
        //given
        final int lottoCount = 6;

        //when
        List<Lotto> lottos = LottoMachine.createLotto(lottoCount);

        //then
        assertThat(lottoCount).isEqualTo(lottos.size());
    }

}
