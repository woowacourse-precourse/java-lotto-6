package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoResultsTest {

    @Test
    void 로또의_총_우승_금액_계산에_성공한다() {
        // given
        List<Rank> ranks = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, MISS, FIRST);
        LottoResults lottoResults = new LottoResults(ranks);
        long expectedResult = (long)FIRST.getWinningMoney() +
                SECOND.getWinningMoney() +
                THIRD.getWinningMoney() +
                FOURTH.getWinningMoney() +
                FIFTH.getWinningMoney() +
                MISS.getWinningMoney() +
                FIRST.getWinningMoney();

        // when
        long totalWinningMoney = lottoResults.calculateTotalWinningMoney();

        // then
        assertThat(totalWinningMoney).isEqualTo(expectedResult);
    }

}
