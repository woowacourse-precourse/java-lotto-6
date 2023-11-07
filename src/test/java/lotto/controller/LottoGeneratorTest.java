package lotto.controller;

import static lotto.constant.GameOptions.MAX_NUMBER;
import static lotto.constant.GameOptions.MIN_NUMBER;
import static lotto.constant.GameOptions.NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator = new LottoGenerator();

    @RepeatedTest(10)
    @DisplayName("로또를 생성하는 기능")
    void generate() {
        Lotto lotto = lottoGenerator.generate();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(NUMBER_COUNT.getValue());

        Set<Integer> set = new HashSet<>(numbers);
        assertThat(set).hasSize(NUMBER_COUNT.getValue());

        for (Integer number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_NUMBER.getValue());
            assertThat(number).isLessThanOrEqualTo(MAX_NUMBER.getValue());
        }

        assertThat(isSorted(numbers)).isTrue();
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                return false; // 오름차순이 아님
            }
        }
        return true; // 오름차순임
    }
}