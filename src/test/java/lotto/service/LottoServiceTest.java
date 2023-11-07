package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("유효하지 않은 구매 금액 입력 시 예외 발생")
    void testValidatePurchaseAmountWithInvalidAmount() {
        LottoService service = new LottoService(new NumberGenerator());
        assertThrows(IllegalArgumentException.class, () -> service.validatePurchaseAmount(-1000));
    }

    @Test
    @DisplayName("1000원 단위가 아닌 금액 입력 시 예외 발생")
    void testValidatePurchaseAmountWithNonThousandMultiple() {
        LottoService service = new LottoService(new NumberGenerator());
        assertThrows(IllegalArgumentException.class, () -> service.validatePurchaseAmount(1500));
    }

    @Test
    @DisplayName("유효한 구매 금액 입력 시 예외 발생하지 않음")
    void testValidatePurchaseAmountWithValidAmount() {
        LottoService service = new LottoService(new NumberGenerator());
        assertDoesNotThrow(() -> service.validatePurchaseAmount(2000));
    }
}