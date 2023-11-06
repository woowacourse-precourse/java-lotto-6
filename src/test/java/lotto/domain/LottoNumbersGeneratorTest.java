package lotto.domain;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {
    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createLottoBySort() {
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            assertThat(Collections.max(numbers)).isGreaterThanOrEqualTo(1);
            assertThat(Collections.min(numbers)).isLessThanOrEqualTo(45);
        }
    }

    @DisplayName("로또 번호 중복 숫자 테스트")
    @Test
    void createLottoByDuplicate() {
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }

    @DisplayName("로또 번호 사이즈 테스트")
    @Test
    void createLottoBySize() {
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = LottoNumbersGenerator.generate();
            assertThat(numbers.size()).isEqualTo(6);
        }
    }
}
