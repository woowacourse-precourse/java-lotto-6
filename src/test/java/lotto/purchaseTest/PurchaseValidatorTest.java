package lotto.purchaseTest;

import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PurchaseValidatorTest {

    private static final int DIVIDER = 1000;

    @ParameterizedTest
    @ValueSource(strings = {"500O", "500X", "X5000"})
    @DisplayName("구입 금액에 숫자 이외의 값이 입력된 경우")
    public void purchaseMoneyNumberFormatTest(String money){
        //given

        //when

        //then
        assertThatThrownBy(() -> PurchaseAmountValidator.validateMoneyType(money))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-50000, -2000 , -1000})
    @DisplayName("구입 금액이 0원 이하일(0장보다 덜 구매하는) 경우")
    public void ifMoneyIsLessThanZeroTest(int money){
        //given

        //when

        //then
        assertThatThrownBy(() -> PurchaseAmountValidator.validateMoneyLessThanZero(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1010, 5009})
    @DisplayName("구입 금액을 1000원 단위로 입력하지 않은 경우")
    public void purchaseMoneyDivideTest(int money){
        //given

        //when

        //then
        assertThatThrownBy(() -> PurchaseAmountValidator.validateMoneyDivide(money, DIVIDER))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
