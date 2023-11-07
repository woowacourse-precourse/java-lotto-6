package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.Constants.LottosConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {
    @DisplayName("로또 등수 개수 세기")
    @Test
    void countLottoPrize() {
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
            add(new Lotto(Arrays.asList(1,2,3,4,5,7)));
            add(new Lotto(Arrays.asList(1,2,3,4,5,8)));
            add(new Lotto(Arrays.asList(1,2,3,4,8,9)));
            add(new Lotto(Arrays.asList(1,2,3,8,9,10)));
        }};
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonus = 7;
        HashMap<LottosConstants, Integer> result = new HashMap<>() {{
            put(LottosConstants.SIX_MATCH, 1);
            put(LottosConstants.FIVE_MATCH_BONUS, 1);
            put(LottosConstants.FIVE_MATCH, 1);
            put(LottosConstants.FOUR_MATCH, 1);
            put(LottosConstants.THREE_MATCH, 1);
            put(LottosConstants.NONE, 0);
        }};

        WinningCalculator winningCalculator = new WinningCalculator();
        winningCalculator.calculateMatchNumbers(lottos, lotto.getNumbers(), bonus);
        assertThat(winningCalculator.getWinningCount()).isEqualTo(result);
    }

    @DisplayName("로또 총 수익률 계산하기")
    @Test
    void calculateRateOfReturn() {
        int amount = 8;
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
            add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
            add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
            add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
            add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
            add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
            add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
            add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        }};
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonus = 7;

        WinningCalculator winningCalculator = new WinningCalculator();
        winningCalculator.calculateMatchNumbers(lottos, lotto.getNumbers(), bonus);
        assertThat(winningCalculator.calculateROI(amount)).isEqualTo("62.5");
    }

}