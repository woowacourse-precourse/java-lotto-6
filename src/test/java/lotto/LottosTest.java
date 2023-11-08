package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottosTest {
    @DisplayName("구입한 금액만큼 로또가 발행되어 다수의 로또가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void createLottos(int money) {
        LottoCount lottoCount = new LottoCount(new Money(money));
        Lottos lottos = LottoGenerator.generateLottos(lottoCount);
        List<Lotto> testLottos = lottos.get();

        assertThat(testLottos).hasSize(lottoCount.getLottoCount());
    }
}
