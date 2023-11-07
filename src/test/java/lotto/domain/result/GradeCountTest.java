package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GradeCountTest {

    @Test
    void 개수를_1_증가시킨다() {
        //Arrange
        GradeCount gradeCount = new GradeCount(Grade.FIRST);

        //Act
        gradeCount.increment();

        //Assert
        assertThat(gradeCount.getCount()).isEqualTo(1);
    }
}