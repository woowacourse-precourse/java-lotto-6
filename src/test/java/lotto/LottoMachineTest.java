package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("구매개수 만큼의 복권 번호를 발급한다.")
    @Test
    void publishLotteries() {
        LottoMachine lottoMachine = new LottoMachine();
        int buyCount = 10;

        List<Lotto> lotteries = lottoMachine.publishLotteries(buyCount);

        int result = lotteries.size();
        int expected = 10;
        assertEquals(result, expected);
    }
}