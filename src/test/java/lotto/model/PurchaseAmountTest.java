package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.exception.input.NumbersEmptyException;
import lotto.util.exception.operation.AmountDivisionException;
import lotto.util.exception.operation.AmountLessThanZeroException;
import lotto.util.exception.operation.AmountParseException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Test
    void exchangeAmount() {
        assertEquals(8, new PurchaseAmount("8000").exchangeAmount());
    }

    @Test
    void exchangePurchase() {
        assertEquals(8000, new PurchaseAmount("8000").exchangePurchase());
    }

    @Test
    void 예외_빈_값_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(NumbersEmptyException.class);
    }

    @Test
    void 예외_입력값_정수_변환_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount("abc"))
               .isInstanceOf(AmountParseException.class);
    }

    @Test
    void 예외_입력값_1000원_단위로_나누기_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount("1500"))
              .isInstanceOf(AmountDivisionException.class);
    }

    @Test
    void 예외_입력값_0원_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount("0"))
                .isInstanceOf(AmountLessThanZeroException.class);
    }

    @Test
    void 예외_입력값_음수_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount("-1"))
               .isInstanceOf(AmountLessThanZeroException.class);
    }
}