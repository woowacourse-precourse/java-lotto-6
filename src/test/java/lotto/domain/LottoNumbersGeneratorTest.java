package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {
    @DisplayName("로또 번호 생성 시 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void RandomNumberGenerator() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        assertThat(lottoNumbersGenerator.generateLottoNumbers()).size().isEqualTo(6);
    }
}
