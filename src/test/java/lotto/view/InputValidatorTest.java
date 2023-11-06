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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,", "1.2.3", "한,글"})
    void 당첨번호를_입력받을때_숫자_리스트로_구분할_수_없는_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator
                .validateWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "0.1"})
    void 보너스_번호를_입력받을때_정수로_변환할_수_없는_경우_예외가_발생한다(String bonusNumber) {
        assertThatThrownBy(() -> InputValidator
                .validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
