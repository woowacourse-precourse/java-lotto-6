package lotto;

import lotto.validator.InputLottoPurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputLottoPurchaseAmountValidatorTest {

    InputLottoPurchaseAmountValidator inputLottoPurchaseAmountValidator = new InputLottoPurchaseAmountValidator();

    @Test
    @DisplayName("로또 구입 금액 입력 안함 테스트")
    void 로또_구입_금액_입력_안함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonInputPurchaseAmount(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 구입 금액 숫자 아닌 값 테스트")
    void 로또_구입_금액_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonIntegerPurchaseAmount("3000원"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 구입 금액 숫자 아닌 값 테스트2")
    void 로또_구입_금액_숫자_아님2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonIntegerPurchaseAmount("오만원"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 구입 금액 1000원 단위 아님")
    void 로또_구입_금액_1000으로_안나눠짐() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonDivide1000PurchaseAmount("7500"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 구입 금액 0이하인 경우")
    void 로또_구입_금액_0이하() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonOverZeroPurchaseAmount("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 구입 금액 0이하인 경우2")
    void 로또_구입_금액_0이하2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputLottoPurchaseAmountValidator.validateNonOverZeroPurchaseAmount("-1000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
