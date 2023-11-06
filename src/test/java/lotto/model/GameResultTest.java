package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constant.GradeConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void setup() {
        List<GradeConstant> gradeConstants = List.of(
                GradeConstant.FIRST, // 20억
                GradeConstant.FIRST, // 20억
                GradeConstant.SECOND, // 3천만
                GradeConstant.NOTHING // 0원
        );

        gameResult = new GameResult(gradeConstants, 4000);
    }

    @DisplayName("각 등급의 개수를 정확하게 계수할 수 있다.")
    @Test
    void 등급별_개수_확인_테스트() {
        Map<GradeConstant, Integer> gradeResult = gameResult.getGrades();

        assertThat(gradeResult.getOrDefault(GradeConstant.FIRST, 0)).isEqualTo(2);
        assertThat(gradeResult.getOrDefault(GradeConstant.SECOND, 0)).isEqualTo(1);
        assertThat(gradeResult.getOrDefault(GradeConstant.THIRD, 0)).isEqualTo(0);
        assertThat(gradeResult.getOrDefault(GradeConstant.FOURTH, 0)).isEqualTo(0);
        assertThat(gradeResult.getOrDefault(GradeConstant.FIFTH, 0)).isEqualTo(0);
        assertThat(gradeResult.getOrDefault(GradeConstant.NOTHING, 0)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확하게 계산할 수 있다.")
    @Test
    void 수익률_계산_성공_테스트() {
        long totalPrize = 4_030_000_000L;
        double expectedProfitRate = (100 * totalPrize) / (1.0 * 4000);

        assertThat(expectedProfitRate).isEqualTo(gameResult.getProfitRate());
    }
}