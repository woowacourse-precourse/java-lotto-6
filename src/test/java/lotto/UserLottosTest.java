package lotto;

import lotto.domain.UserLottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
