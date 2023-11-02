package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class ValidationTest {

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