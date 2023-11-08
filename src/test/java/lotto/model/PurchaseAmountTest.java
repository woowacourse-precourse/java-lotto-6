package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.exception.input.NumbersNullException;
import lotto.util.exception.operation.AmountDivisionException;
import lotto.util.exception.operation.AmountLessThanZeroException;
import lotto.util.exception.operation.AmountParseException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("입력된 로또 구매 금액을 매 수로 반환하는 테스트")
    @Test
    void 구입_금액_매_수_반환() {
        assertEquals(8, new PurchaseAmount("8000").exchangeAmount());
    }

    @DisplayName("매 수를 구매 금액으로 반환하는 테스트")
    @Test
    void 매_수_구입_금액_반환() {
        assertEquals(8000, new PurchaseAmount("8000").exchangePurchase());
    }

    @Test
    void 예외_빈_값_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(""))
                .isInstanceOf(NumbersNullException.class);
    }

    @Test
    void 예외_입력값_정수_변환_테스트() {
        Assertions.assertThatThrownBy(() -> new PurchaseAmount("1000j"))
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