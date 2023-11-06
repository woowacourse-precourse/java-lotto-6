package lotto.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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

    @DisplayName("당첨 번호 설정")
    @Test
    void testSetWinningNumbers() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.setWinningNumbers(List.of(1,2,3,4,5,6));

        assertThat(lottoMachine.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

}
