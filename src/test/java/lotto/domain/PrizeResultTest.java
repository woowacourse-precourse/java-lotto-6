package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeResultTest {
    @DisplayName("구입금액을 입력하면 수익률을 계산한다.")
    @Test
    void createReturnRate() {
        Money money = Money.from(1000);
        List<Lotto> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lottos lottos = Lottos.from(lottoNumbers);
        WinNumber winNumber = WinNumber.from(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Map<Prize, Integer> prizeResult = new HashMap<>();
        prizeResult.put(Prize.FIRST, 1);
        PrizeResult testPrizeResult = PrizeResult.from(lottos, winNumber);
        double expectedReturnRate = 200000000;
        double actualReturnRate = testPrizeResult.calculateReturnRate(prizeResult, money);

        assertThat(expectedReturnRate).isEqualTo(actualReturnRate);
    }
}
