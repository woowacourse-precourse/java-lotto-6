package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CashierTest {

    private final static int NOTHING = 0;

    @DisplayName("구입 금액이 1000원 단위인 경우 수량 반환")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000})
    public void calculateLotto(int money) {
        // given
        Cashier cashier = new Cashier();

        // when
        int quantity = cashier.calculateMoney(money);

        // then
        assertTrue(quantity != NOTHING);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2020, 3300, 4400})
    public void calculateLottoException(int money) {
        // given
        Cashier cashier = new Cashier();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> cashier.calculateMoney(money));
    }
}
