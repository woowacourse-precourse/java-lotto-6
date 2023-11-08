package lotto;

import lotto.domain.UserLottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.DecimalFormat;

public class UserLottosTest {

    @DisplayName("구입 금액과 당첨 금액으로 수익률을 계산하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"8000:5000:62.5", "2000:50000:2500", "50000:50000:100"},delimiter = ':')
    void calculateRateOfReturn(int purchaseAmount, int winningAmount, String result) {
        UserLottos userLottos = new UserLottos(purchaseAmount);
        double rateOfReturn = userLottos.calculateRateOfReturn(winningAmount);
        DecimalFormat df = new DecimalFormat("#.#");

        Assertions.assertThat(df.format(rateOfReturn)).isEqualTo(result);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {5200, 5500, 1500, 1700, 800})
    void createPurchaseAmountNotDivideByLottoPrice(int purchaseAmount) {
        Assertions.assertThatThrownBy(() -> new UserLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
