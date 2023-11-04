package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import lotto.generator.MockedRandomGenerator;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private LottoGenerator lottoGame = new LottoGenerator();

    @Test
    void 로또_번호_조건_만족_여부_검증() {
        Lotto generatedLotto = lottoGame.generateLotto(new MockedRandomGenerator());

        List<Integer> lottoNumbers = generatedLotto.getLotto();

        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.size()).isEqualTo(
                new HashSet<Integer>(lottoNumbers).size());
        assertThat(
                lottoNumbers.stream()
                        .filter(number -> number > 45 || number < 1)
                        .findFirst()
                        .isPresent()).isEqualTo(false);
    }
}
