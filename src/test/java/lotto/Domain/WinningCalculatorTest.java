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

}