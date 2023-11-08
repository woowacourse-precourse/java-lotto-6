package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("로또생성_금액에 맞는 로또 개수 생성")
    @Test
    void generateTenLottoes() {
        int count = 10;
        Amount amount = new Amount(Lotto.PRICE * count);

        List<Lotto> lottos = lottoGenerator.generateLottoes(amount);

        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}
