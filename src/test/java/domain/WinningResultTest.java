package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static provider.TestProvider.*;

public class WinningResultTest {

    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private WinningResult winningResult;

    @BeforeEach
    void init(){
        List<Integer> winnings = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = createTestBonusNumber(7);
        winningNumbers = createTestWinningNumbers(winnings);
        winningResult = createWinningResult(winningNumbers, bonusNumber);
    }
    @DisplayName("주어진 로또목록과 당첨번호를 토대로 당첨내역이 올바르게 반환하는지 검증한다.")
    @Test
    void checkGetWinningResult() {

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        winningResult.calculateProfit(lottos);

        HashMap<Rank, Integer> result = winningResult.getWinningResult();

        assertEquals(1, result.get(Rank.FIRST));
        assertEquals(1, result.get(Rank.SECOND));
        assertEquals(0, result.get(Rank.THIRD));
        assertEquals(0, result.get(Rank.FOURTH));
        assertEquals(0, result.get(Rank.FIFTH));
    }
}
