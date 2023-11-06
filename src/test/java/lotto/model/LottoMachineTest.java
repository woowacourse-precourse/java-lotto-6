package lotto.model;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("구매 횟수만큼 로또 번호 조합 발행")
    @Test
    void createLottoByPurchaseCount() {
        int purchaseCount = 5;
        LottoMachine lottoMachine = new LottoMachine();

        ArrayList<Lotto> lottoTickets = lottoMachine.runLottoMachine(purchaseCount);

        assertThat(lottoTickets.size()).isEqualTo(purchaseCount);
    }

}
