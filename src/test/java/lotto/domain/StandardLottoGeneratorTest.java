package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StandardLottoGeneratorTest {
    StandardLottoGenerator lottoGenerator = new StandardLottoGenerator();
    @Test
    public void generateLottoNumbers_개수는_6개() {
        //when
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
        //then
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    public void generateLottoNumbers_번호는_유니크() {
        //when
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
        //then
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    public void generateLottoNumbers_1에서_45_사이() {
        //when
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
        Set<Integer> numbersInRange = lottoNumbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .collect(Collectors.toSet());
        //then
        assertThat(numbersInRange).hasSize(6);
    }
}
