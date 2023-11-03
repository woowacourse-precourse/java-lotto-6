package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void isValidLength() {
        // given
        String case1 = "1,2,3,4,5,6";
        String case2 = "1";
        String case3 = "";
        String case4 = ",";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isValidLength(case1, 6);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isValidLength(case2, 6);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isValidLength(case3, 6);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isValidLength(case4, 6);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
        assertThat(result4).as("case4").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInRange() {
        // given
        int case1 = 1;
        int case2 = 45;
        int case3 = 0;
        int case4 = 46;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isInRange(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isInRange(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isInRange(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isInRange(case4);
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
        int case1 = 10000;
        int case2 = 100;
        int case3 = 0;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isValidUnit(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isValidUnit(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isValidUnit(case3);
        });

        // then
        assertThat(result1).as("case1").doesNotThrowAnyException();
        assertThat(result2).as("case2").isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).as("case3").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNumeric() {
        // given
        String case1 = "123";
        String case2 = "abc";
        String case3 = "";
        String case4 = "1,2,3,4,5,6";
        String case5 = "a,b,c,d";
        String case6 = ",,";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.isNumeric(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.isNumeric(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.isNumeric(case3);
        });
        Throwable result4 = catchThrowable(() -> {
            Validation.isNumeric(case4);
        });
        Throwable result5 = catchThrowable(() -> {
            Validation.isNumeric(case5);
        });
        Throwable result6 = catchThrowable(() -> {
            Validation.isNumeric(case6);
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