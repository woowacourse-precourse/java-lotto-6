package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import constants.Grade;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointResultTest {
    @Test
    @DisplayName("각 등수별 당첨 로또 번호의 수를 집계한다.")
    void pointResultTest() {
        //Given
        List<Double> points = new ArrayList<>(List.of(1.0, 3.0, 4.0, 5.0, 5.5, 6.0, 6.0));
        PointResult pointResult = new PointResult(points);

        //When & Then
        assertThat(pointResult.getCountByGrade(Grade.FIRST)).isEqualTo(2);
        assertThat(pointResult.getCountByGrade(Grade.SECOND)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.THIRD)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.FOURTH)).isEqualTo(1);
        assertThat(pointResult.getCountByGrade(Grade.FIFTH)).isEqualTo(1);
    }
}
