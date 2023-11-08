package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.stublottonumbersgenerator.CustomLottoNumbersGeneratorStub;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void 로또를_개수만큼_생성한다() {
        int count = 3;
        LottoGenerator lottoGenerator = new LottoGenerator(
                new CustomLottoNumbersGeneratorStub(List.of(1, 2, 3, 4, 5, 6)));

        Lottos lottos = lottoGenerator.generateLottos(count);

        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }
}
