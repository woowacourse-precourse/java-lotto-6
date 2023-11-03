package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void isInRange() {
        // given
        List<Integer> case1 = new ArrayList<>(List.of(1, 1, 45));
        List<Integer> case2 = new ArrayList<>(List.of(45, 1, 45));
        List<Integer> case3 = new ArrayList<>(List.of(0, 1, 45));
        List<Integer> case4 = new ArrayList<>(List.of(46, 1, 45));

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isInRange(case1.get(0), case1.get(1), case1.get(2));
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isInRange(case2.get(0), case2.get(1), case2.get(2));
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isInRange(case3.get(0), case3.get(1), case3.get(2));
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isInRange(case4.get(0), case4.get(1), case4.get(2));
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").doesNotThrowAnyException();
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("case4").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidUnit() {
        // given
        List<Integer> case1 = new ArrayList<>(List.of(10000, 1000));
        List<Integer> case2 = new ArrayList<>(List.of(100, 1000));
        List<Integer> case3 = new ArrayList<>(List.of(0, 1000));

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isValidUnit(case1.get(0), case1.get(1));
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isValidUnit(case2.get(0), case2.get(1));
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isValidUnit(case3.get(0), case3.get(1));
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumber() {
        // given
        String case1 = "123";
        String case2 = "abc";
        String case3 = "";
        String case4 = "1,2,3,4,5,6";
        String case5 = "a,b,c,d";
        String case6 = ",,";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isNumber(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isNumber(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isNumber(case4);
        });
        Throwable result5 = catchThrowable(() -> {
            Validation.isNumber(case5);
        });
        Throwable result6 = catchThrowable(() -> {
            Validation.isNumber(case6);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("case4").doesNotThrowAnyException();
        assertThat(result5).as("case5").isInstanceOf(IllegalArgumentException.class);
        assertThat(result6).as("case6").isInstanceOf(IllegalArgumentException.class);
    }
}