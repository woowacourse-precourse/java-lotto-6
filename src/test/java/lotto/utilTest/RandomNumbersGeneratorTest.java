package lotto.utilTest;

import java.util.List;
import lotto.util.RandomNumbersGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersGeneratorTest {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    @Test
    void generateSortedLottoTest() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

        List<Integer> lottoNumbers = randomNumbersGenerator.generateSortedLotto();

        assertThat(lottoNumbers)
                .hasSize(LOTTO_SIZE)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> assertThat(number).isBetween(MIN_NUMBER,MAX_NUMBER))
                .isSorted();
    }
}
