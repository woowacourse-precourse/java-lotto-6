package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.NotIntegerException;
import lotto.exception.PurchaseAmountRangeException;
import lotto.validation.InputValidator;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    void _1000원_단위로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        String input = "11500";
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
            .isInstanceOf(InvalidPurchaseAmountException.class);
    }

    @Test
    void _100000원이_초과인_경우_구매시_예외가_발생한다() {
        String input = "100001";
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
            .isInstanceOf(PurchaseAmountRangeException.class);
    }

    @Test
    void _1000원_미만인_경우_구매시_예외가_발생한다() {
        String input = "999";
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
            .isInstanceOf(PurchaseAmountRangeException.class);
    }

    @Test
    void 숫자가_아닌_경우_예외가_발생한다() {
        String input = "money";
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
            .isInstanceOf(NotIntegerException.class);
    }
}
