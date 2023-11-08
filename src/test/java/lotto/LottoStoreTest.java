package lotto;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;
import lotto.ui.InputUI;
import lotto.ui.ResultUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    public void setUp() {
        InputUI inputUI = new MockInputUI();
        ResultUI resultUI = new MockResultUI();
        lottoStore = new LottoStore(inputUI, resultUI);
    }

    @Test
    public void buyLotto_ValidAmount_ReturnsLottoTickets() {
        LottoTickets lottoTickets = lottoStore.buyLotto();

        Assertions.assertNotNull(lottoTickets);

        Assertions.assertEquals(5, lottoTickets.size());
    }

    private static class MockInputUI extends InputUI {
        @Override
        public int getAmount() {
            return 5000;
        }
    }

    private static class MockResultUI extends ResultUI {
        @Override
        public void printBoughtLottos(LottoTickets lottoTickets) {
        }
    }
}