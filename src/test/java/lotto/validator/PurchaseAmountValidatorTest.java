package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 100000})
    @DisplayName("구입 금액이 구입 가능 금액 범위 이내 존재한다.")
    void purchaseAmountInRightRange(int amount) {
        //when
        //then
        PurchaseAmountValidator.checkAmountRange(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 100001})
    @DisplayName("구입 금액이 구입 가능 금액 범위를 초과하면 예외가 발생한다.")
    void purchaseAmountRangeOver(int amount) {
        //when
        //then
        assertThatThrownBy(() -> PurchaseAmountValidator.checkAmountRange(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원, 최대 100000원까지 구매 가능합니다.\n");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000, 51000})
    @DisplayName("구입 금액이 로또 가격과 나누어 떨어진다.")
    void remainNoAmount(int amount) {
        //when
        //then
        PurchaseAmountValidator.checkRemainder(amount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 2010, 10500, 50100})
    @DisplayName("구입 금액이 로또 가격과 나누어 떨어지지 않는다.")
    void existRemainderAmount(int amount) {
        //when
        //then
        assertThatThrownBy(() -> PurchaseAmountValidator.checkRemainder(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액이 나누어 떨어지지 않습니다.\n");
    }
}
