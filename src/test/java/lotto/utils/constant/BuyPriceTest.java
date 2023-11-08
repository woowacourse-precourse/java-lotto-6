package lotto.utils.constant;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BuyPriceTest {

    @Test
    void 구매금액을_생성한다() {
        // given
        BuyPrice buyPrice = new BuyPrice("8000");

        // then
        Assertions.assertThat(buyPrice).isEqualTo(new BuyPrice("8000"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 1500, a"})
    void 입력이_잘못되면_예외가_발생한다(String buyPrice) {
        // when
        Assertions.assertThatThrownBy(() -> new BuyPrice(buyPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
