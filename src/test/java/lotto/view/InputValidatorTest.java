package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"999", "0", "1001", "-1"})
    void 구입금액을_입력받을때_1000원_단위가_아닐경우_예외가_발생한다(String amount) {
        assertThatThrownBy(() -> InputValidator
                .validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "", " ", "##"})
    void 구입금액을_입력받을때_숫자가_아니면_예외가_발생한다(String amount) {
        assertThatThrownBy(() -> InputValidator
                .validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
