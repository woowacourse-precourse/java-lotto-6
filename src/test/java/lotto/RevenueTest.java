package lotto;

import lotto.model.Budget;
import lotto.model.Revenue;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.RankCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RevenueTest {
    private RankCount rankCount;
    private Revenue revenue;
    private Budget budget;

    @BeforeEach
    void setUp() {
        rankCount = new RankCount();
        budget = new Budget(8000);
    }

    @DisplayName("Rank5 당첨시 수익률 테스트")
    @Test
    void calculateRevenueRank5() {
        //given
        rankCount.incrementCount(LottoRank.RANK5);
        //when
        revenue = new Revenue(rankCount, budget);
        //then
        assertThat(revenue.getRevenue())
                .isEqualTo("62.5");
    }

    @DisplayName("Rank4, Rank5 당첨시 수익률 테스트")
    @Test
    void calculateRevenueRank4AndRank5() {
        //given
        rankCount.incrementCount(LottoRank.RANK5);
        rankCount.incrementCount(LottoRank.RANK4);
        //when
        revenue = new Revenue(rankCount, budget);
        //then
        assertThat(revenue.getRevenue())
                .isEqualTo("687.5");
    }

    @DisplayName("Rank1 당첨시 수익률 테스트")
    @Test
    void calculateRevenueRank1() {
        //given
        rankCount.incrementCount(LottoRank.RANK1);
        //when
        revenue = new Revenue(rankCount, budget);
        //then
        assertThat(revenue.getRevenue())
                .isEqualTo("25,000,000.0");
    }
}
