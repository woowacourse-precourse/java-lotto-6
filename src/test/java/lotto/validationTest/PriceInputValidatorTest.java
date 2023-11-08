package lotto.validationTest;

import lotto.validation.PriceInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PriceInputValidatorTest {
    @DisplayName("구매 금액이 1000단위로 정상 입력된 상황 테스트")
    @Test
    public void testValidPriceInput() {
        String validPrice = "1000";

        assertThatCode(() -> PriceInputValidator.validate(validPrice))
                .doesNotThrowAnyException();
    }

    @DisplayName("구매 금액 중간에 공백이 있을 때 예외 처리")
    @Test
    public void testInputNotAlone() {
        String invalidPrice = "1 000";

        assertThatIllegalArgumentException().isThrownBy(() -> PriceInputValidator.validate(invalidPrice))
                .withMessage("입력값이 한 개가 아닙니다.");
    }

    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외 처리")
    @Test
    public void testInputNotThousand() {
        String invalidPrice = "1500";

        assertThatIllegalArgumentException().isThrownBy(() -> PriceInputValidator.validate(invalidPrice))
                .withMessage("입력값을 천 단위로 입력해주세요.");
    }

    @DisplayName("구매 금액 입력값이 숫자가 아닐 때 예외 처리")
    @Test
    public void testInputNotDigit() {
        String invalidPrice = "abc";

        assertThatIllegalArgumentException().isThrownBy(() -> PriceInputValidator.validate(invalidPrice))
                .withMessage("입력값이 숫자가 아닙니다.");
    }
}
