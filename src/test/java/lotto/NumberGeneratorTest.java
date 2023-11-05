package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 생성기 테스트")
class NumberGeneratorTest {
    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    @DisplayName("생성할 로또 번호 개수 만큼 숫자를 생성해야 한다.")
    @Test
    public void generate_ShouldReturnCorrectSize() {
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

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있어야 한다.")
    @Test
    public void generate_ShouldReturnSortedNumbers() {
        int size = 6;
        List<Integer> generatedNumbers = generator.generate(size);

        assertThat(generatedNumbers).isSorted();
    }

    @DisplayName("로또 번호는 중복을 허용하지 않는다.")
    @Test
    public void generate_ShouldNotHaveDuplicateNumbers() {
        int size = 6;
        List<Integer> generatedNumbers = generator.generate(size);

        assertThat(generatedNumbers).doesNotHaveDuplicates();
    }
}