package lotto.domain.valueobject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.config.ScoreConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    private static final Long FIRST_REWARD = 2000000000L;
    private static final Long SECOND_REWARD = 30000000L;
    private static final Long FORTH_REWARD = 50000L;
    private Statistics statistics;
    private List<ScoreConfig> scores_4등_2개_2등_1개;
    private List<ScoreConfig> scores_1등_1개_2등_1개;

    @BeforeEach
    void setUp() {
        statistics = new Statistics();
        scores_4등_2개_2등_1개 = Arrays.asList(ScoreConfig.FORTH, ScoreConfig.SECOND, ScoreConfig.FORTH);
        scores_1등_1개_2등_1개 = Arrays.asList(ScoreConfig.FIRST, ScoreConfig.SECOND);
    }

    @DisplayName("해당 등수가 잘 카운팅 됐는지 확인한다.(4등 2개, 2등 1개)")
    @Test
    void incrementWinningCount_4등_2개_2등_1개() {
        statistics.incrementWinningCount(scores_4등_2개_2등_1개);
        Map<ScoreConfig, Integer> winning = statistics.getWinning();

        assertThat(winning.get(ScoreConfig.FIRST)).isEqualTo(0);
        assertThat(winning.get(ScoreConfig.SECOND)).isEqualTo(1);
        assertThat(winning.get(ScoreConfig.FORTH)).isEqualTo(2);
    }

    @DisplayName("출력해야하는 형식 순서대로 리스트가 반환되는지 확인한다.")
    @Test
    void getFormattedScores() {
        List<ScoreConfig> expectedScores = List.of(
                ScoreConfig.NOTHING,
                ScoreConfig.FIFTH,
                ScoreConfig.FORTH,
                ScoreConfig.THIRD,
                ScoreConfig.SECOND,
                ScoreConfig.FIRST
        );

        List<ScoreConfig> result = statistics.getFormattedScores();

        assertThat(result).isEqualTo(expectedScores);
    }

    @DisplayName("4등 2개와 2등 1개의 수익률인 30100000을 리턴한다.")
    @Test
    void getRevenue_4등_2개_2등_1개() {
        Long expectedRevenue = 2 * FORTH_REWARD + SECOND_REWARD;

        statistics.incrementWinningCount(scores_4등_2개_2등_1개);
        Long result = statistics.getRevenue();

        assertThat(result).isEqualTo(expectedRevenue);
    }

    @DisplayName("1등 1개와 2등 1개를 해도 오버플로우가 일어나지 않는다.")
    @Test
    void getRevenue_1등_1개_2등_1개() {
        Long expectedRevenue = FIRST_REWARD + SECOND_REWARD;

        statistics.incrementWinningCount(scores_1등_1개_2등_1개);
        Long result = statistics.getRevenue();

        assertThat(result).isEqualTo(expectedRevenue);
    }
}