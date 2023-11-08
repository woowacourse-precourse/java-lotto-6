package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.RandomLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    private final RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있어야 한다.")
    @Test
    public void generate_ShouldReturnSortedNumbers() {
        int size = 6;
        List<Integer> generatedNumbers = generator.generate(size);

        assertThat(generatedNumbers).isSorted();
    }
    @DisplayName("생성할 로또 번호 개수 만큼 숫자를 생성해야 한다.")
    @Test
    public void generate_ShouldReturnCorrectSize(){
        int size = 6;
        List<Integer> generatedNumbers = generator.generate(size);
        assertThat(generatedNumbers).hasSize(size);
    }

    @DisplayName("로또 번호는 1이상 45이하여야 한다.")
    @Test
    public void generate_ShouldReturnNumbersBetweenOneAndFortyFive() {
        int size = 6;
        List<Integer> generatedNumbers = generator.generate(size);

        assertThat(generatedNumbers).allMatch(num -> num >= 1 && num <= 45);
    }
}
