package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    @Test
    public void generateLottoNumbers_개수는_6개() {
        //when
        List<Integer> lottoNumbers = randomNumberGenerator.generateNumbers();
        //then
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    public void generateLottoNumbers_번호는_유니크() {
        //when
        List<Integer> lottoNumbers = randomNumberGenerator.generateNumbers();
        //then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    public void generateLottoNumbers_1에서_45_사이() {
        //when
        List<Integer> lottoNumbers = randomNumberGenerator.generateNumbers();
        Set<Integer> numbersInRange = lottoNumbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .collect(Collectors.toSet());
        //then
        assertThat(numbersInRange).hasSize(6);
    }
}
