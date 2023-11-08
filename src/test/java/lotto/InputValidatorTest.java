package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

public class InputValidatorTest {
    @DisplayName("구입금액이 1,000원 단위로 입력되었는지 검사")
    @Test
    void 구입금액_천_단위_테스트() {
        // given
        int case1 = 5_500;
        int case2 = 5_000;

        // when
        Throwable result1 = catchThrowable(() -> {
            InputValidator.validatePurchaseAmount(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            InputValidator.validatePurchaseAmount(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }

    @DisplayName("구입금액이 숫자로 입력되었는지 검사")
    @Test
    void 구입금액_숫자_테스트() {
        // given
        String case1 = "오천원";
        String case2 = "5000";

        // when
        Throwable result1 = catchThrowable(() -> {
            InputValidator.validateInputIsNumeric(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            InputValidator.validateInputIsNumeric(case2);
        });

        // then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).doesNotThrowAnyException();
    }
}
