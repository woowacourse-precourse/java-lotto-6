package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.io.ConsoleManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {

    private LottoBuyer lottoBuyer;

    @BeforeEach
    void setUp() {
        ConsoleManager consoleManager = new ConsoleManager();
        lottoBuyer = new LottoBuyer(consoleManager);
    }

    @Test
    @DisplayName("구입 금액으로 로또 구입 개수를 구한다.")
    void getLottoCount_LottoPrice() {
        // Given
        long price = 8_000;

        // When
        long lottoCount = lottoBuyer.getLottoCount(price);

        // Then
        assertThat(lottoCount).isEqualTo(price / 1000);
    }

}