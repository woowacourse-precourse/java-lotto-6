package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Message;
import utils.Validator;

public class ValidatorTest {

    @Test
    void checkMoneyInput_NonPositiveInteger() {
        String moneyInput = "-1000";
        Assertions.assertThatThrownBy(() -> Validator.checkMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NON_POSITIVE_INTEGER.getMessage());
    }

    @Test
    void checkMoneyInput_NullOrBlank() {
        String moneyInput = "";
        Assertions.assertThatThrownBy(() -> Validator.checkMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NULL_OR_BLANK.getMessage());
    }

    @Test
    void checkMoneyInput_LowerThanThousand() {
        String moneyInput = "500";
        Assertions.assertThatThrownBy(() -> Validator.checkMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.LOWER_THAN_1000.getMessage());
    }

    @Test
    void checkMoneyInput_NotDivisibleByThousand() {
        String moneyInput = "1500";
        Assertions.assertThatThrownBy(() -> Validator.checkMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.NOT_DIVISIBLE_BY_1000.getMessage());
    }
}
