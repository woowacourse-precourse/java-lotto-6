package lotto.lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("정상 동작 테스트")
    @Test
    void ok() {
        LottoNumberGenerator lottoNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        List<Lotto> lottos = LottoGenerator.generate(lottoNumberGenerator, 1);
        lottos.forEach(lotto -> {
            Assertions.assertThat(lotto.toString())
                    .isEqualTo("[1, 2, 3, 4, 5, 6]");
        });
    }
}