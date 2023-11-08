package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResultTest {

    @DisplayName("5등 2명 4등 1명 인 경우의 당첨 등수 결과 집계")
    @Test
    void calculateWinningOfFifthAndFourth() {
        List<Integer> matchResult = List.of(3, 3, 4, 1, 2);
        WinningResult winningResult = new WinningResult();
        Map<String, Long> rank = new HashMap<>();

        rank.put("5th", Long.valueOf(2));
        rank.put("4th", Long.valueOf(1));
        rank.put("3rd", Long.valueOf(0));
        rank.put("2nd", Long.valueOf(0));
        rank.put("1st", Long.valueOf(0));

        winningResult.calculate(matchResult);
        Assertions.assertThat(winningResult.getWinningResult()).isEqualTo(rank);
    }

    @DisplayName("당첨이 하나도 안된 경우의 당첨 등수 결과 집계")
    @Test
    void calculateNoWinning() {
        List<Integer> matchResult = List.of(1, 1, 2, 1, 2);
        WinningResult winningResult = new WinningResult();
        Map<String, Long> rank = new HashMap<>();

        rank.put("5th", Long.valueOf(0));
        rank.put("4th", Long.valueOf(0));
        rank.put("3rd", Long.valueOf(0));
        rank.put("2nd", Long.valueOf(0));
        rank.put("1st", Long.valueOf(0));

        winningResult.calculate(matchResult);
        Assertions.assertThat(winningResult.getWinningResult()).isEqualTo(rank);
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

