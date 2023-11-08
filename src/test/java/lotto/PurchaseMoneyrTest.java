package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyrTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseMoney() {
        assertThatThrownBy(() -> new PurchaseMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
