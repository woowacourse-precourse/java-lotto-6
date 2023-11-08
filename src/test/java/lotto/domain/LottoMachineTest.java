package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    @DisplayName("지불한 금액에 따라 로또를 발급한다.")
    void createLottoTicket() {
        // given
        Money money = new Money(2000);
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoTicket lottoTicket = lottoMachine.buy(money, () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // then
        Assertions.assertEquals(2, lottoTicket.getLottos().size());
    }
}
