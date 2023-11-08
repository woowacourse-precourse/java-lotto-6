package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    @DisplayName("구매 숫자가 1000으로 나눠떨어지지 않거나 MAX_PRICE 이상이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1200, 0, 1000000})
    void createPurchaseWithWrongMoney(Integer money) {
        assertThatThrownBy(() -> new Purchase(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumberOfPurchases() {
    }
}