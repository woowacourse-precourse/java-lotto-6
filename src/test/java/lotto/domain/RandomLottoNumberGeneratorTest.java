package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성기는 6개의 각기 다른 번호를 생성한다")
    @Test
    void 여섯_개의_각기_다른_번호_생성() {
        LottoNumberGenerator generator = new RandomLottoNumberGenerator();

        List<Integer> numbers = generator.generate();

        assertThat(numbers).hasSize(6);
        Set<Integer> uniqueNumbers = numbers.stream().collect(Collectors.toSet());
        assertThat(uniqueNumbers).hasSize(6);
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @DisplayName("생성된 로또 번호는 1부터 45 범위 내에 있어야 한다")
    @Test
    void 로또_번호_범위_테스트() {
        LottoNumberGenerator generator = new RandomLottoNumberGenerator();

        List<Integer> numbers = generator.generate();

        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("생성된 로또 번호는 정렬되어야 한다")
    @Test
    void 로또_번호_정렬_테스트() {
        LottoNumberGenerator generator = new RandomLottoNumberGenerator();

        List<Integer> numbers = generator.generate();

        assertThat(numbers).isSorted();
    }
}
