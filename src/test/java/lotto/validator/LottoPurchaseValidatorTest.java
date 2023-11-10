package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseValidatorTest {
    @Test
    void 금액이_천원단위가_아니면_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoPurchaseValidator.validatePurchase(1500))
                .withMessageContaining("금액이 천원 단위가 아닙니다.");
    }
}