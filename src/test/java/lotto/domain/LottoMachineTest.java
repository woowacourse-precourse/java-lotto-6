package lotto.domain;

import lotto.utils.GameRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구입금액에 따라 로또를 반환한다.")
    @Test
    void returnTicketByMoney() {
        int expectedTicket = 5000 / GameRules.MINIMUN_UNIT.getValue();
        int actualTicket = LottoMachine.buyLottos(Money.from(5000)).getLottos().size();
        assertThat(actualTicket).isEqualTo(expectedTicket);
    }
}