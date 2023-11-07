package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 6개를 생성한다.")
    @Test
    void generateLottoNumbers() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호는 1부터 45사이의 숫자를 생성한다.")
    @Test
    void shouldHaveNumbersBetween1And45() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        assertThat(isNumbers1And45(numbers)).isTrue();
    }

    private boolean isNumbers1And45(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("로또 번호는 중복된 숫자를 가질 수 없다.")
    @Test
    void shouldHaveUniqueNumbers() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        assertThat(numbers).doesNotHaveDuplicates();
    }
}