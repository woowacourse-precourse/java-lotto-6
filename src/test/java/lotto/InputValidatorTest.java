package lotto;

import lotto.ui.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000","5000","100000"})
    void 금액_정상_입력_테스트(String test) {
        assertDoesNotThrow(() -> inputValidator.validateAmount(test));
    }

    @ParameterizedTest
    @ValueSource(strings = {"one","?","1one"})
    void 금액_입력_시_숫자가_아닌_문자가_포함된_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateAmount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void 금액_입력_시_null_또는_공백인_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateAmount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void 금액_입력_시_값이_0인_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateAmount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1510"})
    void 금액_입력_시_1000원_단위가_아닌_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateAmount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100001"})
    void 금액_입력_시_최대한도를_초과하는_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateAmount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 당첨_번호_입력_시_null_또는_공백인_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1?2?3?4?5?6","one,two"})
    void 당첨_번호_입력_시_숫자_또는_쉼표_외_문자가_입력된_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","1,2,3,4,5","1,2,3,4,5,6,7"})
    void 당첨_번호_입력_시_숫자가_6개가_아닌_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111111111111111"})
    void 당첨_번호_입력_시_자료형을_초과하는_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5","1,2,3,4,5,46"})
    void 당첨_번호_숫자가_1부터_45_사이가_아닌_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 보너스_번호_입력_시_null_또는_공백인_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"one","?","1one"})
    void 보너스_번호_입력_시_숫자가_아닌_문자가_포함된_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111111111111111111"})
    void 보너스_번호_입력_시_자료형을_초과하는_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","46"})
    void 보너스_번호_숫자가_1부터_45_사이가_아닌_경우_예외_발생(String test) {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
}