package lotto.dto;

import static lotto.model.LottoRank.FIFTH_RANK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.Statistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticDtoTest {

    private StatisticDto statisticDto;

    @BeforeEach
    void init() {
        List<Integer> matchedNumberCount = List.of(3, 3, 4, 4, 5, 5, 6);
        List<Boolean> containBonusNumber = List.of(false, true, false, true, false, true, true);
        Statistic statistic = Statistic.createStatistic(matchedNumberCount, containBonusNumber);

        statisticDto = StatisticDto.from(statistic);
    }

    @DisplayName("순위 카운트 테스트")
    @Test
    void getRankCount_test() {
        // then
        assertEquals(2, statisticDto.getFifthRankCount());
        assertEquals(2, statisticDto.getFourthRankCount());
        assertEquals(1, statisticDto.getThirdRankCount());
        assertEquals(1, statisticDto.getSecondRankCount());
        assertEquals(1, statisticDto.getFirstRankCount());
    }

    @DisplayName("순위 정보 불변 테스트")
    @Test
    void unmodifiable_test() {
        assertThrows(UnsupportedOperationException.class, () -> statisticDto.getRank().put(FIFTH_RANK, 5));
    }
}
