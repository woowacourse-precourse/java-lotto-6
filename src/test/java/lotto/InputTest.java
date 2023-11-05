package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    Application application = new Application();

    @ParameterizedTest
    @EmptySource
    void 입력_하지_않았을_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkEmpty(input))
                .withMessage(ErrorMessage.REQUIRED_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "eight"})
    void 입력_값이_숫자가_아닐_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkNumber(input))
                .withMessage(ErrorMessage.IS_NOT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {8001})
    void 구입_금액이_천원_단위가_아닐_때_예외_발생(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkUnit(purchaseAmount))
                .withMessage(ErrorMessage.PURCHASE_AMOUNT_UNIT);
    }

    @Test
    void 구입_금액이_0원일_때_예외_발생() {
        int purchaseAmount = 0;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkZero(purchaseAmount))
                .withMessage(ErrorMessage.PURCHASE_AMOUNT_ZERO);
    }

    @ParameterizedTest
    @NullSource
    void 입력_값이_null일_때_예외_발생(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.checkNull(input))
                .withMessage(ErrorMessage.NULL);
    }

    @Test
    void 입력_받은_구입_금액을_검증한다_성공() {
        String purchaseAmount = "8000";

        int result = application.validate(purchaseAmount);

        assertThat(result).isEqualTo(8000);
    }
}
