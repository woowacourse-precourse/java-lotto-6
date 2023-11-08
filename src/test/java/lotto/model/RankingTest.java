package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("일치하는 당첨 번호 개수 및 보너스 번호 일치 여부가 주어졌을 때 당첨 등수를 구한다")
class RankingTest {
    private static final int FIRST_RANKING_ACCORDED_COUNT = 6;
    private static final int SECOND_RANKING_ACCORDED_COUNT = 5;
    private static final int THIRD_RANKING_ACCORDED_COUNT = 5;
    private static final int FOURTH_RANKING_ACCORDED_COUNT = 4;
    private static final int FIFTH_RANKING_ACCORDED_COUNT = 3;
    private static final int NO_RANKING_ACCORDED_COUNT = 2;
    private static final boolean HAS_BONUS_NUMBER = true;
    private static final boolean DO_NOT_HAS_BONUS_NUMBER = false;

    @Test
    @DisplayName("1등 정보가 주어졌을 때 1등 랭킹 반환 테스트")
    void firstRankingTest() {
        Ranking firstRanking = Ranking.getRanking(FIRST_RANKING_ACCORDED_COUNT, DO_NOT_HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.FIRST_RANKING);
    }

    @Test
    @DisplayName("2등 정보가 주어졌을 때 2등 랭킹 반환 테스트")
    void secondRankingTest() {
        Ranking firstRanking = Ranking.getRanking(SECOND_RANKING_ACCORDED_COUNT, HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.SECOND_RANKING);
    }

    @Test
    @DisplayName("3등 정보가 주어졌을 때 3등 랭킹 반환 테스트")
    void thirdRankingTest() {
        Ranking firstRanking = Ranking.getRanking(THIRD_RANKING_ACCORDED_COUNT, DO_NOT_HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.THIRD_RANKING);
    }

    @Test
    @DisplayName("4등 정보가 주어졌을 때 4등 랭킹 반환 테스트")
    void fourthRankingTest() {
        Ranking firstRanking = Ranking.getRanking(FOURTH_RANKING_ACCORDED_COUNT, DO_NOT_HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.FOURTH_RANKING);
    }

    @Test
    @DisplayName("5등 정보가 주어졌을 때 5등 랭킹 반환 테스트")
    void fifthRankingTest() {
        Ranking firstRanking = Ranking.getRanking(FIFTH_RANKING_ACCORDED_COUNT, DO_NOT_HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.FIFTH_RANKING);
    }

    @Test
    @DisplayName("당첨되지 않은 정보가 주어졌을 때 랭킹 반환 테스트")
    void noRankingTest() {
        Ranking firstRanking = Ranking.getRanking(NO_RANKING_ACCORDED_COUNT, DO_NOT_HAS_BONUS_NUMBER);
        assertThat(firstRanking).isEqualTo(Ranking.NO_RANK);
    }
}