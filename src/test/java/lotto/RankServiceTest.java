package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import lotto.config.LottoRank;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.service.RankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankServiceTest {

    RankService rankService;

    @BeforeEach
    void setUp() {
        User user = new User(5, createFakeLottos());
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 7;
        rankService = new RankService(user, winningNumbers, bonusNumber);
    }

    @DisplayName("로또 당첨 순위계산이 정상적으로 동작하는가?")
    @Test
    void testCalculateLottoRanks() {
        int[] winningCount = rankService.calculateLottoRanks();

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
        LottoRank rank = rankService.calculateLottoRank(firstPrizeLotto);
        assertEquals(LottoRank.FIRST, rank);
    }

    @DisplayName("로또 2등이 정상적으로 반환되는가?")
    @Test
    void testCalculateLottoRank_BonusPrize() {
        Lotto bonusPrizeLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        LottoRank rank = rankService.calculateLottoRank(bonusPrizeLotto);
        assertEquals(LottoRank.BONUS, rank);
    }

    @DisplayName("로또 당첨이 없을 때 정상적으로 반환되는가?")
    @Test
    void testCalculateLottoRank_Null() {
        Lotto noPrizeLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));
        LottoRank rank = rankService.calculateLottoRank(noPrizeLotto);
        assertNull(rank);
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
