package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @DisplayName("발행할 수 있는 갯수만큼 로또 발행하는 기능 테스트")
    @Test
    void checkLottoCount(){
        List<Lotto> lottos = LottoMachine.generate(7000);

        assertThat(lottos.size()).isEqualTo(7);
    }
}
