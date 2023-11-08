//package lotto.domain;
//
//import lotto.domain.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WinningStatisticTest {
//    @DisplayName("당첨 통계에 등급을 정상적으로 추가할 수 있다.")
//    @Test
//    void addRank() {
//        WinningStatistic winningStatistic = new WinningStatistic();
//
//        winningStatistic.addRank(Rank.FIRST);
//        winningStatistic.addRank(Rank.SECOND);
//        winningStatistic.addRank(Rank.THIRD);
//        winningStatistic.addRank(Rank.MISS);
//        winningStatistic.addRank(Rank.MISS);
//        winningStatistic.addRank(Rank.MISS);
//
//        assertThat(winningStatistic.getCountByRank(Rank.FIRST)).isEqualTo(1);
//        assertThat(winningStatistic.getCountByRank(Rank.SECOND)).isEqualTo(1);
//        assertThat(winningStatistic.getCountByRank(Rank.THIRD)).isEqualTo(1);
//        assertThat(winningStatistic.getCountByRank(Rank.MISS)).isEqualTo(3);
//    }
//
//    @DisplayName("수익률을 정상적으로 계산할 수 있다.")
//    @Test
//    void calculateYield() {
//        WinningStatistic winningStatistic = new WinningStatistic();
//        winningStatistic.addRank(Rank.FIRST);
//        winningStatistic.addRank(Rank.SECOND);
//        winningStatistic.addRank(Rank.THIRD);
//        winningStatistic.addRank(Rank.MISS);
//        winningStatistic.addRank(Rank.MISS);
//
//        int totalAmount = 5000;
//
//        double expectedYield = (2_000_000_000 + 30_000_000 + 1_500_000) / (double) totalAmount * 100;
//
//        assertThat(winningStatistic.calculateYield(totalAmount)).isEqualTo(expectedYield);
//    }
//
//}
//
