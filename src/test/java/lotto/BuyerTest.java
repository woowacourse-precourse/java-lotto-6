package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest {
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createAmountByWrongUnit() {
        Buyer buyer = new Buyer();
        assertThatThrownBy(() -> buyer.setPurchaseAmount(8200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}