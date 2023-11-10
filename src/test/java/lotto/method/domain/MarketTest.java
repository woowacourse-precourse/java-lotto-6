package lotto.method.domain;

import lotto.domain.Market;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MarketTest {
    private final Market market = new Market();

    @Test
    @DisplayName("로또 1장당 1000원의 가격으로 로또를 발행한다.")
    void issueLotto() {
        assertThat(market.issueLotto(8000)).size()
                .isEqualTo(8);
    }

    @Test
    @DisplayName("입력 금액이 1000원 단위가 아닐 시에 예외가 발생한다.")
    void paymentNotUnitOfThousands() {
        assertThatThrownBy(() -> market.issueLotto(8111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 금액이 1000원 미만일 시에 예외가 발생한다.")
    void paymentUnderOneThousands() {
        assertThatThrownBy(() -> market.issueLotto(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
