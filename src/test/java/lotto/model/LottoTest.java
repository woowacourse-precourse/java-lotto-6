package lotto.model;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoTest {
    @DisplayName("로또 번호가 유효한 범위 내에 있으면 생성에 성공한다.")
    @Test
    void createValidLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertNotNull(lotto);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1이상 45이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoByRangeOut() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 개의 같은 로또 번호를 생성해 동등함을 확인한다.")
    @Test
    void testEqualsAndHashCode() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto1).isEqualTo(lotto2);

        assertThat(lotto1.hashCode()).isEqualTo(lotto2.hashCode());
    }

    @DisplayName("로또 번호가 정렬되어야 한다.")
    @Test
    void sortLottoNumbers() {
        List<Integer> unsortedNumbers = List.of(6, 1, 5, 2, 4, 3);
        Lotto lotto = new Lotto(unsortedNumbers);

        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertIterableEquals(sortedNumbers, lotto.getNumbers());
    }
}