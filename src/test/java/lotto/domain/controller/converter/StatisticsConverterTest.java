package lotto.domain.controller.converter;

import lotto.domain.controller.converter.StatisticsConverter;
import lotto.domain.dto.Statistics;
import lotto.domain.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsConverterTest {

    @Test
    void 주어진_통계에_맞는_출력값_포맷으로_변환한다() {
        StatisticsConverter converter = new StatisticsConverter();
        Statistics statistics = new Statistics(
                List.of(Result.SIX_MATCH, Result.FIVE_MATCH_WITH_BONUS,
                        Result.FIVE_MATCH, Result.FOUR_MATCH, Result.THREE_MATCH),
                50.0
        );
        String expected = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                """;

        String actual = converter.convert(statistics);
        System.out.println(actual);

        assertEquals(expected, actual);
    }
}