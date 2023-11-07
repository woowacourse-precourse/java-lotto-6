package lotto.view.inputview;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

class InputValueTypeTest {

    @Test
    @DisplayName("PurchasePrice getCreateFunction() 테스트")
    void testGetCreateFunctionWithNull() {
        Function<String, Object> createFunction = InputValueType.PURCHASE_PRICE.getCreateFunction(null);
        Object resultObject = createFunction.apply("1000");

        Assertions.assertThat(createFunction).isNotNull();
        Assertions.assertThat(resultObject).isInstanceOf(PurchasePrice.class);
    }

    @Test
    @DisplayName("WinningNumbers getCreateFunction() 테스트")
    void testGetCreateFunctionWithAnyObject() {
        Function<String, Object> createFunction = InputValueType.WINNING_NUMBERS.getCreateFunction(null);
        Object resultObject = createFunction.apply("1,2,3,4,5,6");

        Assertions.assertThat(createFunction).isNotNull();
        Assertions.assertThat(resultObject).isInstanceOf(WinningNumbers.class);
    }

    @Test
    @DisplayName("BonusNumber getCreateFunction()에 requiredObject를 주입한 경우 테스트")
    void testGetCreateFunctionWithRequiredObject() {
        WinningNumbers winningNumbers = BDDMockito.mock(WinningNumbers.class);

        Function<String, Object> createFunction = InputValueType.BONUS_NUMBER.getCreateFunction(winningNumbers);
        Object resultObject = createFunction.apply("1");

        Assertions.assertThat(createFunction).isNotNull();
        Assertions.assertThat(resultObject).isInstanceOf(BonusNumber.class);
    }

    @Test
    @DisplayName("BonusNumber getCreateFunction()에 requiredObject를 주입하지 않은 경우 테스트")
    void testGetCreateFunctionWithNoRequiredObject() {
        Function<String, Object> createFunction = InputValueType.BONUS_NUMBER.getCreateFunction(null);

        Assertions.assertThat(createFunction).isNotNull();
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, () -> {
            createFunction.apply("1");
        });
    }
}