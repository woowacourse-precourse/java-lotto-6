package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void isCorrectUnit() {
        // given
        int case1 = 1000;
        int case2 = 10;
        int case3 = -300;
        int unit = 1000;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isCorrectUnit(case1, unit);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isCorrectUnit(case2, unit);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isCorrectUnit(case3, unit);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isOver() {
        // given
        int case1 = 1000;
        int case2 = 0;
        int case3 = -300;
        int min = 0;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isOver(case1, min);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isOver(case2, min);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isOver(case3, min);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInRange() {
        // given
        int case1 = 1;
        int case2 = 45;
        int case3 = 0;
        int case4 = 46;
        int min = 1;
        int max = 45;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isInRange(case1, min, max);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isInRange(case2, min, max);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isInRange(case3, min, max);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isInRange(case4, min, max);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").doesNotThrowAnyException();
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("case4").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isDuplicate() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int case1 = 1;
        int case2 = 7;
        int case3 = 44;
        int case4 = -1;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isDuplicate(lotto, case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isDuplicate(lotto, case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isDuplicate(lotto, case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isDuplicate(lotto, case4);
        });

        // then
        assertThat(result1).as("case1").isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).as("case2").doesNotThrowAnyException();
        assertThat(result3).as("case3").doesNotThrowAnyException();
        assertThat(result4).as("case4").doesNotThrowAnyException();
    }
}