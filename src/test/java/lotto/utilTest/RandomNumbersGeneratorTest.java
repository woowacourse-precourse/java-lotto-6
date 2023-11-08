package lotto.utilTest;

import java.util.List;
import lotto.util.RandomSortedLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersGeneratorTest {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    @DisplayName("무작위 6자리 난수를 생성하고 조건테스트")
    @Test
    void generateSortedLottoTest() {
        RandomSortedLottoNumberGenerator randomNumbersGenerator = new RandomSortedLottoNumberGenerator();

        List<Integer> lottoNumbers = randomNumbersGenerator.generateSortedLotto();

        assertThat(lottoNumbers)
                .hasSize(LOTTO_SIZE)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(MIN_NUMBER,MAX_NUMBER))
                .isSorted();
    }
}
