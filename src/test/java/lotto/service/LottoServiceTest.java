package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
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

    @Test
    @DisplayName("로또 티켓 생성 시 6개의 유일한 숫자를 포함해야 함")
    void testGenerateSingleLotto() {
        LottoService service = new LottoService(new NumberGenerator());
        Lotto lotto = service.generateSingleLotto();
        List<Integer> numbers = lotto.getNumbers();

        assertEquals(6, numbers.size());
        assertEquals(6, numbers.stream().distinct().count());
    }

    @Test
    @DisplayName("지정된 수의 로또 티켓을 생성해야 함")
    void testGenerateMultipleLottos() {
        LottoService service = new LottoService(new NumberGenerator());
        List<Lotto> lottos = service.generateMultipleLottos(5);

        assertEquals(5, lottos.size());
    }
}