package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("주문 받은 로또 개수만큼 로또를 발급해준다.")
    @Test
    void createLottosByNumber() {
        int count = 5;
        List<Lotto> lottos = lottoMachine.createLottosBy(5);

        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}
