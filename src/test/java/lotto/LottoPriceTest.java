package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPriceTest {
    @DisplayName("구입 금액이 1,000원보다 작으면 예외가 발생한다.")
    @Test
    void createLottoPriceByUnderPrice() {
        assertThatThrownBy(() -> new LottoPrice(700))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoPriceByNotDividedPrice() {
        assertThatThrownBy(() -> new LottoPrice(3100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
