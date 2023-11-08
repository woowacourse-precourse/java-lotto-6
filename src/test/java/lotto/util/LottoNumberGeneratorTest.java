package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUM_LOTTO_NUMBERS = 6;

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @DisplayName("6개의 로또 숫자를 생성한다.")
    @Test
    void generateSixLottoNumbers() {
        assertThat(lottoNumberGenerator.generateLottoNumbers().size()).isEqualTo(NUM_LOTTO_NUMBERS);
    }

    @DisplayName("범위 내의 로또 숫자를 생성한다.")
    @Test
    void generateValidLottoNumbers() {
        List<Integer> lottoNumbers = lottoNumberGenerator.generateLottoNumbers();

        assertThat(lottoNumbers)
                .allSatisfy(number -> assertThat(number).isBetween(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }
}