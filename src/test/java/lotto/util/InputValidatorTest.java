package lotto.util;

import static lotto.util.InputValidator.validatePurchaseAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("구매 금액이 공백일 때 오류 발생")
    @Test
    void validateInputEmpty(){
        assertThatThrownBy(()->validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 입력 값은 공백일 수 없습니다");
    }

    @DisplayName("구매 금액이 정수타입이 아닐 떄 오류 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abc","123j","!!","천원","1000.1"})
    void purchaseAmountNotIntegerTypeTest(String purchaseAmount){
        assertThatThrownBy(()->validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] : 입력 값은 정수 타입이어야 합니다");
    }

}