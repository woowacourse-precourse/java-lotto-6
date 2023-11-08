package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoCount;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {
    @DisplayName("구입한 금액만큼 로또가 발행된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void createLottoCount(int money) {
        LottoCount lottoCount = new LottoCount(new Money(money));
        assertThat(lottoCount.getLottoCount()).isEqualTo(money / 1000);
    }
}
