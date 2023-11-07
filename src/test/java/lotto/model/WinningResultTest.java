package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResultTest {

    @Test
    void WinningResult_5등_2명_4등_1명_인경우() {
        List<Integer> matchResult = List.of(3, 3, 4, 1, 2);
        WinningResult winningResult = new WinningResult();
        Map<String, Long> rank = new HashMap<>();

        rank.put("5th", Long.valueOf(2));
        rank.put("4th", Long.valueOf(1));

        winningResult.calculate(matchResult);
        Assertions.assertThat(winningResult.getWinningResult()).isEqualTo(rank);
    }

    @Test
    void WinningResult_당첨이_하나도_안된_경우() {
        List<Integer> matchResult = List.of(1, 1, 2, 1, 2);
        WinningResult winningResult = new WinningResult();

        winningResult.calculate(matchResult);
        Assertions.assertThat(winningResult.getWinningResult()).isEmpty();
    }

    @Test
    void determineRankByBonus_당첨_결과가_2등인_경우() {
        int rank = Rule.THIRD_RANK.value();
        boolean isBonusHit = true;

        Assertions.assertThat(WinningResult.determineRankByBonus(rank, isBonusHit)).isEqualTo(Rule.SECOND_RANK.value());
    }

    @Test
    void determineRankByBonus_당첨_결과가_2등이_아닌_경우() {
        int rank = Rule.THIRD_RANK.value();
        boolean isBonusHit = false;

        Assertions.assertThat(WinningResult.determineRankByBonus(rank, isBonusHit)).isEqualTo(rank);
    }
}

