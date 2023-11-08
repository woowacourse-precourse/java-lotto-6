package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankingServiceTest {
    private RankingService rankingService = new RankingService();
    private final List<Ranking> rankingsCriteria =
            List.of(Ranking.SECOND, Ranking.THIRD, Ranking.THIRD, Ranking.NONE);
    private Map<Ranking, Integer> countsCriteria = new HashMap<>();

    @BeforeEach
    void setUpCounts() {
        for (Ranking ranking: Ranking.values()) {
            countsCriteria.put(ranking, 0);
        }
        for (Ranking ranking: rankingsCriteria) {
            int currentCount = countsCriteria.get(ranking);
            countsCriteria.put(ranking, currentCount + 1);
        }
    }

    @DisplayName("랭킹 결과 배열 정상 여부")
    @Test
    void checkRankingResultMaking() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto("1,2,3,4,5,8"),
                new Lotto("1,2,3,4,7,8"),
                new Lotto("2,3,4,5,7,8"),
                new Lotto("6,7,8,9,10,11")
        );
        Lotto winningNumbers = new Lotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");

        // when, then
        assertThat(rankingService.calculateRankingResults(lottos, winningNumbers, bonusNumber))
                .isEqualTo(rankingsCriteria);
    }

    @DisplayName("랭킹 카운트 정상 여부")
    @Test
    void checkRankingCounts() {
        assertThat(rankingService.countRanking(rankingsCriteria))
                .isEqualTo(countsCriteria);
    }
}
