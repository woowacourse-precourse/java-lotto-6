package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
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
}
