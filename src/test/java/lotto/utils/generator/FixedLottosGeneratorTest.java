package lotto.utils.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixedLottosGeneratorTest {

    @DisplayName("테스트를 위한 고정된 번호의 로또를 생성한다")
    @Test
    void asd() {
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        FixedLottosGenerator fixedLottosGenerator = new FixedLottosGenerator(lottos);
        assertThat(fixedLottosGenerator.generateLottos(3000)).isEqualTo(lottos);
    }

}
