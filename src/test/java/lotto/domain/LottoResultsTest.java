package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoResultsTest {

    private List<Rank> ranks;

    @BeforeEach
    void setUp() {
        ranks = List.of(
                THIRD, FOURTH, FIFTH, MISS, FIFTH, FIFTH, FIFTH, MISS, MISS
        );
    }

    @Test
    void 로또의_총_우승_금액_계산에_성공한다() {
        // given
        LottoResults lottoResults = new LottoResults(ranks);
        long expectedResult = (long) THIRD.getWinningMoney() +
                FOURTH.getWinningMoney() +
                FIFTH.getWinningMoney() +
                MISS.getWinningMoney() +
                FIFTH.getWinningMoney() +
                FIFTH.getWinningMoney() +
                FIFTH.getWinningMoney() +
                MISS.getWinningMoney() +
                MISS.getWinningMoney();

        // when
        long totalWinningMoney = lottoResults.calculateTotalWinningMoney();

        // then
        assertThat(totalWinningMoney).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "10_000/15700.0",
                    "13_000/12076.9",
                    "370_000/424.3",
                    "578_000/271.6"
            },
            delimiter = '/')
    void 투입_금액을_입력하면_로또_수익률_계산에_성공한다(int inputPrice, double expected) {
        // given
        LottoResults lottoResults = new LottoResults(ranks);

        // when
        double actualProfitRate = lottoResults.calculateTotalProfitRate(inputPrice);

        // then
        assertThat(actualProfitRate).isEqualTo(expected);
    }

    @Test
    void 등수_결과_리스트를_그룹화하는데_성공한다() {
        // given
        LottoResults lottoResults = new LottoResults(ranks);

        // when
        Map<Rank, Long> rankGroup = lottoResults.generateRankGroup();
        Map<Rank, Long> expectedRankGroup = Map.of(
                FIRST, 0L,
                SECOND, 0L,
                THIRD, 1L,
                FOURTH, 1L,
                FIFTH, 4L,
                MISS, 3L
        );

        // then
        assertThat(rankGroup).containsExactlyInAnyOrderEntriesOf(
                expectedRankGroup
        );
    }

}
