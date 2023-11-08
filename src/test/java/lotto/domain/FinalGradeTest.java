package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FinalGradeTest {

    @Nested
    @DisplayName("사용자의 당첨 상금을 얻어오는 기능 테스트")
    class PlayerTotalPrizeTest {
        @Test
        @DisplayName("각 등수를 1 번씩 했을 때의 상금은 2_031_555_000 이다.")
        void oneTimeEachRank() {
            // given
            List<Rank> ranks = Lists.newArrayList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
            FinalGrade finalGrade = new FinalGrade(ranks);
            BigDecimal expectedTotalPrice = new BigDecimal(2031555000L);
            // when
            BigDecimal totalPrize = finalGrade.getPlayerTotalPrize();
            // then
            Assertions.assertThat(totalPrize).isEqualTo(expectedTotalPrice);
        }

        @Test
        @DisplayName("1등을 10번 했을 때의 상금은 20_000_000_000 원 이다.")
        void tenTimeFirstRank() {
            // given
            List<Rank> ranks = Lists.newArrayList(Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST,
                    Rank.FIRST,
                    Rank.FIRST, Rank.FIRST, Rank.FIRST, Rank.FIRST);
            FinalGrade finalGrade = new FinalGrade(ranks);
            BigDecimal expectedTotalPrice = new BigDecimal(20_000_000_000L);
            // when
            BigDecimal totalPrice = finalGrade.getPlayerTotalPrize();
            // then
            Assertions.assertThat(totalPrice).isEqualTo(expectedTotalPrice);
        }
    }

    @Nested
    @DisplayName("사용자의 로또 구입 금액을 얻어오는 기능 테스트")
    class PlayerTotalPurchaseAmountTest {
        @Test
        void elevenTimePurchase() {
            List<Rank> ranks = Lists.newArrayList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH,
                    Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST, Rank.FIFTH);
            FinalGrade finalGrade = new FinalGrade(ranks);
            BigDecimal expectedAmount = new BigDecimal(11000L);
            Assertions.assertThat(finalGrade.getPlayerTotalPurchaseAmount()).isEqualTo(expectedAmount);
        }
    }

    /*
     * test data:
     * 1) Rank.FIRST: 10_000_000
     * 2) totalPrize: 20_000_000_000_000_000
     * success
     *
     * test data:
     * 1) Rank.FIRST: 100_000_000
     * 2) totalPrize: 200_000_000_000_000_000
     * Heap Memory Leak
     *
     * result: Big Decimal 오버 플로우 발생 전에 메모리 릭 먼저 발생
     */
    @Test
    @DisplayName("플레이어 전체 상금 계산 중 오버 플로우, 허용 가능치 스트레스 테스트")
    void bigValueTest() {
        // given
        List<Rank> ranks = create();
        FinalGrade finalGrade = new FinalGrade(ranks);
        BigDecimal expectedTotalPrize = new BigDecimal("20000000000000000");
        // when
        BigDecimal resultTotalPrize = finalGrade.getPlayerTotalPrize();
        // then
        Assertions.assertThat(resultTotalPrize).isEqualTo(expectedTotalPrize);
    }

    private List<Rank> create() {
        int total = 10000000;
        List<Rank> ranks = new ArrayList<>();
        for (int count = 0; count < total; count++) {
            ranks.add(Rank.FIRST);
        }
        return ranks;
    }
}