package lotto;

import static lotto.Model.Price.ERROR_NOT_NUMBER;
import static lotto.Model.Price.ERROR_NOT_PURCHASE_LOTTO;
import static lotto.Model.Price.ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE;
import static lotto.Model.Price.ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.Model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    private Price price;

    @DisplayName("Price로 문자가 주어지면 예외 발생 테스트.")
    @Test
    void validateNumber1() {
        String input = "5000원";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_NUMBER);
    }

    @DisplayName("Price가 int타입 넘어가면 예외 발생 테스트")
    @Test
    void validateNumber2() {
        String input = "4000000001";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_NUMBER);
    }

    @DisplayName("Price가 한 개의 로또 가격 단위로 떨어지지 않으면 예외 발생 테스트")
    @Test
    void validateDividingUnitOfOneLottoPrice() {
        String input = "500";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_UNIT_PRICE_OF_PURCHASED_LOTTO);
    }

    @DisplayName("Price가 0원이나 음수면 예외 발생하는 테스트")
    @Test
    void validateNumberRange1() {
        String input = "0";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_PURCHASE_LOTTO);
    }

    @DisplayName("Price가 0원이나 음수면 예외 발생하는 테스트")
    @Test
    void validateNumberRange2() {
        String input = "-1000";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_PURCHASE_LOTTO);
    }

    @DisplayName("Price가 1000원으로 떨어지나 로또 최대 구입 가격인 20억~int타입 사이면 예외 발생하는 테스트")
    @Test
    void validateNumberRange3() {
        String input = "2000001000";

        assertThatThrownBy(() -> new Price(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_OVER_MAX_PRICE_OF_LOTTO_FOR_PURCHASE);
    }

    @BeforeEach
    void set() {
        price = new Price("8000");
    }

    @DisplayName("Price에 따라 구매한 로또 개수를 집계하는 테스트")
    @Test
    void countPurchasedLotto() {
        int expectedCountingLottos = price.countPurchasedLotto();
        int actualCountingLottos = 8;

        assertThat(expectedCountingLottos).isEqualTo(actualCountingLottos);
    }

    @DisplayName("당첨금액에 따라 수익률이 만들어지는지 테스트")
    @Test
    void makeWinningRate1() {
        int totalWinningPrize = 5000;

        double actualWinningRate = price.makeWinningRate(totalWinningPrize);
        double expectedWinningRate = 62.5f;

        assertThat(actualWinningRate).isEqualTo(expectedWinningRate);
    }

    @DisplayName("당첨금액에 따라 수익률이 만들어지는지 테스트")
    @Test
    void makeWinningRate2() {
        price = new Price("3000");
        int totalWinningPrize = 5000;

        double actualWinningRate = price.makeWinningRate(totalWinningPrize);
        double expectedWinningRate = 166.7d;

        assertThat(actualWinningRate).isEqualTo(expectedWinningRate);
    }
}
