package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("중복 번호 확인")
    @Test
    void checkDuplicatedNumbers() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> LottoGenerator.generateAnswerLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 존재합니다.");
    }

    @DisplayName("리스트 크기 확인")
    @Test
    void checkListSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThatThrownBy(() -> LottoGenerator.generateAnswerLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개의 번호를 입력해야 합니다.");
    }

    @DisplayName("값 범위 확인")
    @Test
    void checkRange() {
        List<Integer> numbers = List.of(0, 44, 45, -1, 6, 7);
        assertThatThrownBy(() -> LottoGenerator.generateAnswerLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("정상 생성 확인")
    @Test
    void normalObject() {
        // given
        List<Integer> numbers = List.of(10, 13, 26, 38, 39, 42);
        List<Integer> shuffledNumbers = List.of(13, 10, 26, 38, 39, 42);

        // when
        Lotto original = LottoGenerator.generateAnswerLotto(numbers);
        Lotto another = LottoGenerator.generateAnswerLotto(shuffledNumbers);

        // then
        assertThat(original).isEqualTo(another);
        assertThat(original).hasSameHashCodeAs(another);
    }
}