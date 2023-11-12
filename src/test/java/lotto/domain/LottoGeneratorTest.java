package lotto.domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("생성한 번호 개수 확인")
    @Test
    void generateNumbersSizeTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> deduplicationNumbers = lottoGenerator.generateDeduplicationNumbers();
        assertThat(deduplicationNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성한 번호 중복 확인")
    @Test
    void generateDeduplicationTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> numbers = lottoGenerator.generateDeduplicationNumbers();
        Set<Integer> deduplicationChecker = new HashSet<>(numbers);
        assertThat(deduplicationChecker.size()).isEqualTo(6);
    }

    @DisplayName("배열 오름차순 정렬 확인")
    @Test
    void listSortTest() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);

        Collections.sort(numbers);
        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4));
    }
}
