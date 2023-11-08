package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.config.LottoRank;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    private LottoService lottoService;


    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        lottoService.user = new User(1000, createFakeLottos());
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        lottoService.initWinningNumbers(winningNumbers);
        lottoService.bonusNumber = 7;
    }

    @DisplayName("로또 당첨 순위계산이 정상적으로 동작하는가?")
    @Test
    void testCalculateLottoRanks() {
        int[] winningCount = lottoService.calculateLottoRanks();

        assertEquals(1, winningCount[LottoRank.FIRST.getRank()]);
        assertEquals(1, winningCount[LottoRank.BONUS.getRank()]);
        assertEquals(2, winningCount[LottoRank.FIFTH.getRank()]);
        assertEquals(0, winningCount[LottoRank.FOURTH.getRank()]);
        assertEquals(0, winningCount[LottoRank.THIRD.getRank()]);
    }

    @DisplayName("로또 1등이 정상적으로 반환되는가?")
    @Test
    void testCalculateLottoRank_FirstPrize() {
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        LottoRank rank = lottoService.calculateLottoRank(firstPrizeLotto);
        assertEquals(LottoRank.FIRST, rank);
    }

    @DisplayName("로또 2등이 정상적으로 반환되는가?")
    @Test
    void testCalculateLottoRank_BonusPrize() {
        Lotto bonusPrizeLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        LottoRank rank = lottoService.calculateLottoRank(bonusPrizeLotto);
        assertEquals(LottoRank.BONUS, rank);
    }

    @DisplayName("로또 당첨이 없을 때 정상적으로 반환되는가?")
    @Test
    void testCalculateLottoRank_Null() {
        Lotto noPrizeLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));
        LottoRank rank = lottoService.calculateLottoRank(noPrizeLotto);
        assertNull(rank);
    }

    @DisplayName("수익률 계산이 정상적으로 작동하는가?(1등:1번, 2등:1번, 3등:2번)")
    @Test
    void testRateOfReturn() {
        BigDecimal expected = new BigDecimal("203300.0");


        lottoService.calculateLottoRanks();
        BigDecimal result = lottoService.rateOfReturn();


        assertEquals(expected, result);
    }

    private List<Lotto> createFakeLottos() {
        return Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9))
        );
    }
}
