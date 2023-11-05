package lotto;

import lotto.Service.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoMachineTest {
    @DisplayName("구입금액에 따른 로또 갯수 체크")
    @Test
    void checkLottoCount() {
        Integer price = 7000;

        Integer lottoCount = LottoMachine.lottoCount(price);

        assertThat(lottoCount).isEqualTo(7);
    }

}
