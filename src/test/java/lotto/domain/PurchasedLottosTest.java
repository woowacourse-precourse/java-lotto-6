package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import lotto.constants.Messages;
import lotto.utils.generator.FixedLottosGenerator;
import lotto.utils.generator.RandomLottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottosTest {

    @DisplayName("구매금액이 최소값 미만 일 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosWhenAmountIsLessThanMinimum() {
        assertThatThrownBy(() -> new PurchasedLottos(800, new RandomLottosGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_LESS_THAN_UNIT);
    }

    @DisplayName("구매금액이 최대값을 초과할 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosWhenAmountExceedsMaximum() {
        assertThatThrownBy(() -> new PurchasedLottos(100001000, new RandomLottosGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_MAX_RANGE);
    }

    @DisplayName("구매금액이 1000원단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosBy() {
        assertThatThrownBy(() -> new PurchasedLottos(12300, new RandomLottosGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
    }

    @DisplayName("구매한로또들이 정상적으로 생성된다.")
    @Test
    void shouldCreatePurchasedLottosSuccessfully() {
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        assertDoesNotThrow(() -> new PurchasedLottos(3000,
                new FixedLottosGenerator(lottos)));
    }
}
