package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("입력한 개수만큼 로또가 발행되는지 테스트")
    @Test
    void generateLottosTest() {
        int LottoCount = 5;
        List<Lotto> lottos = LottoGenerator.generateLottos(LottoCount);
        assertThat(LottoCount).isEqualTo(lottos.size());
    }
}
