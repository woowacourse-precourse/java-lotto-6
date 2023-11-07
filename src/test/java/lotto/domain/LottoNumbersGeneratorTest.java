package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumbersGeneratorTest {

    @Test
    void RandomNumberGenerator() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        assertThat(lottoNumbersGenerator.generateLottoNumbers()).size().isEqualTo(6);
    }
}
