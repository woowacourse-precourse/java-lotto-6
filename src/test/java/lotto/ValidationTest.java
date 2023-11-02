package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

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
        String case3 = "abc";
        String case2 = "";

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

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
    }
}