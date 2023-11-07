package lotto.utility;

import lotto.domain.Lotto;
import lotto.utility.enums.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @DisplayName("사용자 입력금액이 없는 경우")
    @Test
    void createPurchaseAmountNoInput(){
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ExceptionMessages.IS_EMPTY.getMessage());
    }

    @DisplayName("사용자 입력금액이 숫자가 아닌 경우")
    @Test
    void createPurchaseAmountNotNumber(){
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount("jun"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ExceptionMessages.NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("사용자 입력금액이 1000원 단위가 아닌 경우")
    @Test
    void createPurchaseAmountNotDivisibleByThousand(){
        assertThatThrownBy(() -> Validation.vaildatePurchaseAmount("23100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }
}
