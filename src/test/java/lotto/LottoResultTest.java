package lotto;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.model.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("당첨 결과 확인 - 1등")
    @Test
    void checkWinningRank_FirstPrize() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.getInstance(List.of(1, 2, 3, 4, 5, 6), 7); // 1등 조건

        WinningRank winningRank = lottoResult.checkLotto(lotto, winningNumbers);

        assertEquals(WinningRank.FIRST, winningRank);
    }

    @DisplayName("당첨 결과 확인 - 2등")
    @Test
    void checkWinningRank_SecondPrize() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = WinningNumbers.getInstance(List.of(1, 2, 3, 4, 5, 6), 7); // 2등 조건

        WinningRank winningRank = lottoResult.checkLotto(lotto, winningNumbers);

        assertEquals(WinningRank.SECOND, winningRank);
    }

    @DisplayName("총 결과 메서드 확인")
    @Test
    void makeResult_ShouldCalculateTotalRewardAndRankCounts() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 10, 11))); // 4등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 13, 14, 15))); // 5등

        WinningNumbers winningNumbers = WinningNumbers.getInstance(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoResult.makeResult(lottoTickets, winningNumbers);

        assertEquals(1, lottoResult.getCountByRank(WinningRank.FIRST));
        assertEquals(1, lottoResult.getCountByRank(WinningRank.SECOND));
        assertEquals(1, lottoResult.getCountByRank(WinningRank.THIRD));
        assertEquals(1, lottoResult.getCountByRank(WinningRank.FOURTH));
        assertEquals(1, lottoResult.getCountByRank(WinningRank.FIFTH));
        assertEquals(2031555000L, lottoResult.getTotalReward());
    }
}
