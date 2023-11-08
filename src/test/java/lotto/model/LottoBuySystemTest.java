package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuySystemTest {

    static LottoBuySystem buySystem;

    @BeforeAll
    static void prepare() {
        buySystem = new LottoBuySystem();
    }

    @DisplayName("적절한 금액이 아닌 경우")
    @ParameterizedTest
    @CsvSource({
            "1500",
            "2100",
            "310j",
            "-1000"
    })
    void testPriceValidate(String price) {
        assertThatThrownBy(() -> buySystem.validatePrice(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 대한 로또 갯수")
    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "10000, 10",
            "3000, 3"
    })
    void testBuyLottos(String price, int expectedLottosCount) {
        buySystem.buyLottos(price);
        int lottosCount = buySystem.getLottosCount();

        assertThat(lottosCount).isEqualTo(expectedLottosCount);
    }

}