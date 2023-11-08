package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumbersSizeShouldThrowException() {
        List<Integer> numbersWithInvalidSize = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(numbersWithInvalidSize))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("개수가 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoWithDuplicateNumbersShouldThrowException() {
        List<Integer> numbersWithDuplicate = Arrays.asList(1, 2, 3, 4, 5, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(numbersWithDuplicate))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복이 있습니다.");
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoWithNumbersOutOfRangeShouldThrowException() {
        List<Integer> numbersOutOfRange = Arrays.asList(0, 2, 3, 4, 5, 46);
        Assertions.assertThatThrownBy(() -> new Lotto(numbersOutOfRange)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자여야 합니다.");
    }
}