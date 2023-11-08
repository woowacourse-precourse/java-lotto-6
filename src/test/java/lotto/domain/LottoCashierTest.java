package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCashierTest {
    private static final String VALIDATE_UNIT_MESSAGE = "[ERROR] 1000원 단위로 구입해야 합니다.";

    @ParameterizedTest
    @CsvSource({"10000, 10", "5000, 5", "2000, 2"})
    @DisplayName("금액에 따른 로또 발행 갯수를 정확하게 계산한다.")
    public void testGetLottoCount(int money, int expectedCount) {
        LottoCashier cashier = new LottoCashier();

        int count = cashier.getLottoCount(money);
        assertEquals(expectedCount, count);
    }

    @ParameterizedTest
    @CsvSource({"1500", "0", "100", "10050"})
    @DisplayName("유효하지 않은 금액 입력 시 예외가 발생한다.")
    public void testInvalidLottoCount(int invalidMoney) {
        LottoCashier cashier = new LottoCashier();
        assertThrows(IllegalArgumentException.class, () -> cashier.getLottoCount(invalidMoney), VALIDATE_UNIT_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource({"5", "10"})
    @DisplayName("로또 갯수에 맞게 로또를 생성한다.")
    public void testCreateLottoList(int count) {
        LottoCashier cashier = new LottoCashier();
        List<Lotto> lottos = cashier.createLottoList(count);
        assertEquals(count, lottos.size());
    }
}
