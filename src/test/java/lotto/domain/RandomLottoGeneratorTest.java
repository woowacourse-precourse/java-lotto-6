package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoGeneratorTest {

    @DisplayName("구매 가능한 횟수만큼 로또를 발급한다.")
    @Test
    void generateTest() {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        Lottos lottos = randomLottoGenerator.generate(10);
        assertThat(lottos.getLottos().size()).isEqualTo(10);
    }
}
