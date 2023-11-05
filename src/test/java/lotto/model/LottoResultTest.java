package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoTickets lottoTickets;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    @BeforeEach
    public void setUp() {
        lottoTickets = new LottoTickets();

        initTestObject();

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void initTestObject() {
        Lotto lotto1 = new Lotto(java.util.Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(java.util.Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(java.util.Arrays.asList(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(java.util.Arrays.asList(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(java.util.Arrays.asList(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(java.util.Arrays.asList(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(java.util.Arrays.asList(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(java.util.Arrays.asList(1, 3, 5, 14, 22, 45));
        lottoTickets.addLotto(lotto1);
        lottoTickets.addLotto(lotto2);
        lottoTickets.addLotto(lotto3);
        lottoTickets.addLotto(lotto4);
        lottoTickets.addLotto(lotto5);
        lottoTickets.addLotto(lotto6);
        lottoTickets.addLotto(lotto7);
        lottoTickets.addLotto(lotto8);
    }

    @DisplayName("수익율은 성공적으로 계산한다")
    @Test
    public void testProfitRateCalculation() {
        lottoResult = new LottoResult(lottoTickets, winningLotto);

        BigDecimal expectedProfitRate = new BigDecimal("62.5");

        assertEquals(expectedProfitRate, lottoResult.getProfitRate());
    }
}