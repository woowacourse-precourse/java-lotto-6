package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {4500, 12230, 6666})
    void 구입_금액_입력값_단위_검증(int amount) {
        assertThatThrownBy(() -> Amount.from(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void 구입_금액_입력값_0원이_아닌지_검증() {
        assertThatThrownBy(() -> Amount.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void 구입_금액만큼_로또_발행() {
        // given
        int amount = 2000;
        Amount userAmount = Amount.from(amount);

        // when
        int lottoCount = userAmount.getLottoCount();

        // then
        assertEquals(amount/Constants.LOTTO_PRICE, lottoCount);
    }
}
