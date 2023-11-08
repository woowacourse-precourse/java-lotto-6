package lotto.utils;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsFormatterTest {

    @Test
    @DisplayName("로또 당첨내역 출력 형식은 오름차순이어야 한다.")
    void formatStatisticsCorrectly() {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);
        resultMap.put(LottoRank.FIRST, 1);
        resultMap.put(LottoRank.SECOND, 0);
        resultMap.put(LottoRank.THIRD, 5);
        resultMap.put(LottoRank.FOURTH, 10);
        resultMap.put(LottoRank.FIFTH, 15);

        List<String> formattedStatistics = LottoStatisticsFormatter.formatStatistics(resultMap);

        assertThat(formattedStatistics).containsExactly(
                "3개 일치 (5,000원) - 15개",
                "4개 일치 (50,000원) - 10개",
                "5개 일치 (1,500,000원) - 5개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }

    @Test
    @DisplayName("많은 수도 정상적으로 출력해야 한다")
    void handlesLargeCounts() {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);
        resultMap.put(LottoRank.FIFTH, 1000);

        List<String> formattedStatistics = LottoStatisticsFormatter.formatStatistics(resultMap);

        assertThat(formattedStatistics).containsExactly(
                "3개 일치 (5,000원) - 1000개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }
}