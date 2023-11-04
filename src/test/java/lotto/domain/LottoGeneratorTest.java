package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @DisplayName("로또 번호가 6개 생성되어야 한다")
    @Test
    void createSixNumbers() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        Lotto lotto = generator.generate();

        // then
        assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBER_COUNT);
    }

    @DisplayName("생성된 로또 번호는 1과 45 사이여야 한다")
    @RepeatedTest(10)
    void createNumbersWithinRange() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        Lotto lotto = generator.generate();

        // then
        assertThat(lotto.getNumbers())
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }

    @DisplayName("생성된 로또 번호는 중복되지 않아야 한다")
    @RepeatedTest(10)
    void createUniqueNumbers() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        Lotto lotto = generator.generate();

        // then
        long uniqueNumbersCount = lotto.getNumbers().stream().distinct().count();
        assertThat(uniqueNumbersCount).isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 오름차순으로 정렬되어야 한다")
    @RepeatedTest(10)
    void sortedInAscendingOrder() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        Lotto lotto = generator.generate();
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        sortedNumbers.sort(Integer::compareTo);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(sortedNumbers);
    }
}
