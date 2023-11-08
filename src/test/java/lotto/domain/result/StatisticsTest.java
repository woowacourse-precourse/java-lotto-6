package lotto.domain.result;

import static lotto.domain.grade.Grade.FIFTH;
import static lotto.domain.grade.Grade.values;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.grade.GradeCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 통계를_생성할때_등수_카운트를_초기화한다() {
        //Arrange
        Statistics statistics = Statistics.of();

        //Act
        List<GradeCount> gradeCounts = statistics.getGradeCounts();

        //Assert
        assertThat(gradeCounts)
                .hasSize(values().length)
                .extracting("count")
                .containsOnly(0);
    }

    @Test
    void 등수를_통계에_반영한다() {
        //Arrange
        Statistics statistics = Statistics.of();
        Grade expectedGrade = FIFTH;

        //Act
        statistics.apply(expectedGrade);
        List<GradeCount> gradeCounts = statistics.getGradeCounts();

        //Assert
        assertThat(gradeCounts)
                .filteredOn(gradeCount -> gradeCount.getGrade() == expectedGrade)
                .isNotEmpty()
                .allSatisfy(gradeCount -> assertThat(gradeCount.getCount()).isOne());
    }
}