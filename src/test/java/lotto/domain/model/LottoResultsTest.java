package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import lotto.constant.LottoRank;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultsTest {
    final int MULTIPLYING_NUMBER = 100;
    final long PURCHASE_COST = 10000; // 10장
    LottoResults lottoResults;


    @BeforeEach
    void setUp() {
        LottoPurchaseCost lottoPurchaseCost = new LottoPurchaseCost(PURCHASE_COST);
        // 5개 당첨
        List<LottoRank> lottoRanks = List.of(
                LottoRank.SIX,
                LottoRank.FIVE_WITH_BONUS,
                LottoRank.FIVE_WITHOUT_BONUS,
                LottoRank.FOUR,
                LottoRank.THREE
        );

        lottoResults = new LottoResults(lottoRanks, lottoPurchaseCost);
    }

    @Test
    void 랭크_개수_테스트() {
        Map<LottoRank, Integer> rankCounts = lottoResults.getRankCounts();
        Set<LottoRank> lottoRanks = rankCounts.keySet();

        SoftAssertions softAssertions = new SoftAssertions();

        lottoRanks.forEach(rank -> {
            softAssertions.assertThat(rankCounts.get(rank)).isEqualTo(1);
        });

        softAssertions.assertAll();
    }

    @Test
    void 수익률_테스트() {
        double rateOfReturn = lottoResults.getRateOfReturn();

        Map<LottoRank, Integer> rankCounts = lottoResults.getRankCounts();
        Set<LottoRank> lottoRanks = rankCounts.keySet();
        double winnings = lottoRanks.stream()
                .mapToDouble(rank -> rank.getWinnings() * rankCounts.get(rank))
                .sum();

        double calculatedRateOfReturn = winnings / PURCHASE_COST * MULTIPLYING_NUMBER;
        assertThat(Double.compare(rateOfReturn, calculatedRateOfReturn)).isEqualTo(0);
    }
}