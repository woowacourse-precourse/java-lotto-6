package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningCombinationTest {

    @Test
    @DisplayName("로또 당첨 조합이 옳게 생성된다.")
    void testCreateLottoWinningCombination() {
        // given
        List<Integer> winnerNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        // when
        LottoWinningCombination lottoWinningCombination = LottoWinningCombination.createLottoWinningCombination(
                winnerNums, bonusNum);
        // then
        assertEquals(lottoWinningCombination.getWinnerNums(), winnerNums);
        assertEquals(lottoWinningCombination.getBonusNum(), bonusNum);
    }
}