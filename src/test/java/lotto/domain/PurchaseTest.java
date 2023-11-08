package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @DisplayName("1000으로 나누어지지 않는 경우")
    @Test
    void divisionError() {
        assertThatThrownBy(() -> new Purchase(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0보다 작은 경우")
    @Test
    void underZero() {
        assertThatThrownBy(() -> new Purchase(0))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
