package lotto;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.model.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @DisplayName("당첨 결과 확인 - 1등")
    @Test
    void checkWinningRank_FirstPrize() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.getInstance(List.of(1, 2, 3, 4, 5, 6), 7); // 1등 조건

        WinningRank winningRank = lottoResult.check(lotto, winningNumbers);

        assertEquals(WinningRank.FIRST, winningRank);
    }

    @DisplayName("당첨 결과 확인 - 2등")
    @Test
    void checkWinningRank_SecondPrize() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = WinningNumbers.getInstance(List.of(1, 2, 3, 4, 5, 6), 7); // 2등 조건

        WinningRank winningRank = lottoResult.check(lotto, winningNumbers);

        assertEquals(WinningRank.SECOND, winningRank);
    }
}
