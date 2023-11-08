package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("정상적으로 무작위 로또 번호를 생성하고 저장한다.")
    void generateRandomLottoNumbersTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.getRandomNumbers());

        assertThat(lotto.getNumbers()).isEqualTo(lottoGenerator.getRandomNumbers());
    }
}
