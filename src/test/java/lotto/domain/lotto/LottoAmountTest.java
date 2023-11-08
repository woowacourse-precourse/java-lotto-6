package lotto.domain.lotto;

import lotto.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAmountTest {

    @Test
    void 음수가_주어진_경우_예외를_발생한다() {
        int amount = -1000;

        Assertions.assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
    }

    @Test
    void 숫자0이_주어진_경우_예외를_발생한다() {
        int amount = 0;

        Assertions.assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
    }

    @ParameterizedTest
    @ValueSource(ints = {1200, 2400, 3322})
    void 숫자1000_으로_나누어_떨어지지_않는_경우_예외를_발생한다(int amount) {
        Assertions.assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_DIVIDED_LOTTO_PRICE.message());
    }

    @ParameterizedTest
    @ValueSource(ints = {1100000, 1300000, 100000000})
    void 생성시_최대_구매_금액을_벗어난_정수가_주어진_경우_예외를_발생한다(int amount) {
        Assertions.assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_OUT_OF_BOUND.message());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 40000, 100000})
    void 구매_가능한_로또_개수를_반환한다(int amount) {
        LottoAmount lottoAmount = new LottoAmount(amount);
        int expected = amount / 1000;

        org.junit.jupiter.api.Assertions.assertEquals(expected, lottoAmount.getPurchaseNumber());
    }
}