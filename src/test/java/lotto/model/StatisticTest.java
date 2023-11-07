package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticTest {

    @DisplayName("일치하는 개수와 보너스 번호의 포함 여부에 결과를 리스트로 받아 통계를 생성한다.")
    @Test
    void statistics_create_test() {
        // given
        List<Integer> matchedCount = List.of(3, 3, 4, 4, 5, 5, 6);
        List<Boolean> containBonusNumber = List.of(false, true, false, true, false, true, true);

        // when
        Statistic statistic = Statistic.createStatistic(matchedCount, containBonusNumber);
        Map<LottoRank, Integer> rank = statistic.getRank();

        // then
        assertEquals(2, rank.get(LottoRank.FIFTH_RANK));
        assertEquals(2, rank.get(LottoRank.FOURTH_RANK));
        assertEquals(1, rank.get(LottoRank.THIRD_RANK));
        assertEquals(1, rank.get(LottoRank.SECOND_RANK));
        assertEquals(1, rank.get(LottoRank.FIRST_RANK));
    }
}
