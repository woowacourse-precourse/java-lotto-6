package lotto;

import lotto.model.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generateLottoNumbers() {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();

        List<Integer> lottoNumbers = numberGenerator.generate();

        assertThat(lottoNumbers)
                .isNotNull()
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(1, 45));

        assertThat(lottoNumbers).isSorted();
    }
}
