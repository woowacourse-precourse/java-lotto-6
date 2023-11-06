package lotto.domain;

import lotto.domain.db.PurchaseAmount;
import lotto.domain.db.PurchaseLottoCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseCounterTest {
    @DisplayName("올바른 값을 리턴하는지 확인")
    @Test
    void counterByCorrectValue() {
        int testCount = new PurchaseCounter().counter(8000);

        assertThat(testCount).isEqualTo(8);
    }

    @DisplayName("1,000으로 나누어 떨어지지 않으면 예외가 발생")
    @Test
    void couterBycannotDivide() {
        assertThatThrownBy(() -> new PurchaseCounter().counter(8230))
                .isInstanceOf(IllegalArgumentException.class);
    }
}