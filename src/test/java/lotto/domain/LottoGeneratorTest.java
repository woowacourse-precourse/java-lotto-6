package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.SortedRandomNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        LottoGenerator lottoGenerator = new LottoGenerator(new SortedRandomNumberGenerator());
        Money money = new Money(2000);

        List<Lotto> lottos = lottoGenerator.generateForAmount(money);

        assertThat(lottos.size()).isEqualTo(money.getAmount() / money.getLottoPrice());
    }
}