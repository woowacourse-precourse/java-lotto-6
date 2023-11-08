package lotto.model;

import static lotto.constant.RankingTestConstant.DO_NOT_HAS_BONUS_NUMBER;
import static lotto.constant.RankingTestConstant.FIFTH_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingTestConstant.FIRST_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingTestConstant.FOURTH_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingTestConstant.HAS_BONUS_NUMBER;
import static lotto.constant.RankingTestConstant.NO_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingTestConstant.SECOND_RANKING_ACCORDED_COUNT;
import static lotto.constant.RankingTestConstant.THIRD_RANKING_ACCORDED_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("일치하는 당첨 번호 개수 및 보너스 번호 일치 여부가 주어졌을 때 당첨 등수를 구한다")
class RankingTest {
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