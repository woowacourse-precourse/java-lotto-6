package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private static LottoResult lottoResult;

    @BeforeAll
    private static void beforeAll() {
        lottoResult = new LottoResult();
        lottoResult.addOne(Rank.FIRST);
        lottoResult.addOne(Rank.THIRD);
        lottoResult.addOne(Rank.THIRD);
        lottoResult.addOne(Rank.FIFTH);
        lottoResult.addOne(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨내역 확인")
    void printResults() {
        System.out.println(lottoResult.buildResultString());
    }

    @Test
    @DisplayName("총 당첨금액 확인")
    void getProfitsTest() {
        long profit = lottoResult.getProfits();
        long answer = RankReward.getRewardOf(Rank.FIRST)
                + RankReward.getRewardOf(Rank.THIRD) * 2L
                + RankReward.getRewardOf(Rank.FOURTH)
                + RankReward.getRewardOf(Rank.FIFTH);

        assertThat(profit).isEqualTo(answer);
    }

}