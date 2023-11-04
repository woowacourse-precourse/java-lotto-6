package lotto.service;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외 발생")
    @Test
    void purchaseAmountByNotUnit() {
        final Money money = new Money("1100");
        final LottoService service = new LottoService();

        assertThatThrownBy(() -> service.validateUnit(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("구매 금액이 1000원 단위면 오류가 발생하지 않는다.")
    @Test
    void validateUnitSuccess() {
        final Money money = new Money("11000");
        final LottoService service = new LottoService();

        service.validateUnit(money);
    }
}