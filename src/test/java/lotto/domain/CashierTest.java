package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CashierTest {

    @DisplayName("구입 금액이 1000원 단위인 경우 수량 반환")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    public void calculateLotto(int money) {
        Cashier cashier = new Cashier();
        int quantity = cashier.calculateLotto(money);

        assertTrue(quantity > 0);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2020, 3300, 4400})
    public void calculateLottoException(int money) {
        Cashier cashier = new Cashier();

        assertThrows(IllegalArgumentException.class, () -> cashier.calculateLotto(money));
    }
}
