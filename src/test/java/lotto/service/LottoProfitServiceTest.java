package lotto.service;

import lotto.constant.LottoConstants;
import lotto.domain.LottoWinningRanking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoProfitServiceTest {
    LottoProfitService profitService;
    @BeforeEach
    void beforeEach() {
        profitService = LottoProfitService.getInstance();
    }

    @Test
    @DisplayName("로또 1등 당첨이 되지 않은 경우")
    void calculateProfit() {
        EnumMap<LottoWinningRanking, Integer> winningRankingCountMap = new EnumMap<>(LottoWinningRanking.class);
        winningRankingCountMap.put(LottoWinningRanking.FIRST, 0);

        double actualProfit = profitService.calculateProfit(winningRankingCountMap, 0);
        assertThat(actualProfit).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("로또 수익률 계산")
    void calculateProfit(List<Integer> rankingCount) {
        EnumMap<LottoWinningRanking, Integer> winningRankingCountMap = new EnumMap<>(LottoWinningRanking.class);
        winningRankingCountMap.put(LottoWinningRanking.FIRST, rankingCount.get(0));
        winningRankingCountMap.put(LottoWinningRanking.SECOND, rankingCount.get(1));
        winningRankingCountMap.put(LottoWinningRanking.THIRD, rankingCount.get(2));
        winningRankingCountMap.put(LottoWinningRanking.FOURTH, rankingCount.get(3));
        winningRankingCountMap.put(LottoWinningRanking.FIFTH, rankingCount.get(4));
        winningRankingCountMap.put(LottoWinningRanking.NONE, rankingCount.get(5));

        int lottoCount = 0;
        for (Integer integer : rankingCount) {
            lottoCount += integer;
        }

        long winningAmount = 0L;
        for (Map.Entry<LottoWinningRanking, Integer> value : winningRankingCountMap.entrySet()) {
            if (value.getValue() > 0) {
                if (value.getKey().getWinningAmount() >= LottoWinningRanking.THIRD.getWinningAmount()) {
                    winningAmount += value.getKey().getWinningAmount();
                }
                else if (value.getKey().getWinningAmount() <= LottoWinningRanking.FOURTH.getWinningAmount()) {
                    winningAmount += value.getKey().getWinningAmount() * value.getValue();
                }
            }
        }
        double expectedProfit = (double) winningAmount / (lottoCount * LottoConstants.LOTTO_PRICE.getValue()) * 100.0;
        expectedProfit = Math.round(expectedProfit * 10.0) / 10.0;

        double actualProfit = profitService.calculateProfit(winningRankingCountMap, lottoCount);
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }
    
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
                Arguments.of(Arrays.asList(0, 2, 3, 4, 44, 45)),
                Arguments.of(Arrays.asList(1, 0, 0, 0, 0, 0))
        );
    }
}
