package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    @DisplayName("지갑은 정상적으로 생성이 되어야 한다.")
    void 지갑은_정상적으로_생성되어야_한다() {
        Wallet wallet = new Wallet(1000);

        assertNotNull(wallet);
        assertEquals(1, wallet.calculateCurrencyUnits());
    }

    @Test
    @DisplayName("금액은 0이하이면 오류가 발생한다")
    void 지갑_0원_익셉션발생() {
        assertThrows(IllegalArgumentException.class, () -> new Wallet(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9999, 10000001})
    @DisplayName("금액은 1000으로 나누어지지 않으면 오류가 발생한다.")
    void 금액이_1000으로_나누어지지_않음(int money) {
        assertThrows(IllegalArgumentException.class, () -> new Wallet(money));
    }

    @Test
    @DisplayName("지갑은 수익률을 정확하게 계산해주어야 한다.")
    void 지갑_수익률_정상_계산() {
        Wallet wallet = new Wallet(8000);

        float ratio = wallet.calculateProfitRatio(5000);

        assertEquals(62.5, ratio);
    }
}