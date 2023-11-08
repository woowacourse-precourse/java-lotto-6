package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1부터 45 사이의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬되어 있으면 예외가 발생하지 않아야 함")
    @Test
    void validateSortedLottoNumbers() {
        List<Integer> sortedLottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(sortedLottoNumbers);

        assertThat(lotto.getNumbers()).isEqualTo(sortedLottoNumbers);
    }

    @DisplayName("로또 번호가 정렬되어 있지 않으면 예외가 발생해야 함")
    @Test
    void validateUnsortedLottoNumbers() {
        List<Integer> unsortedLottoNumbers = List.of(6, 2, 4, 3, 1, 5);

        assertThatThrownBy(() -> new Lotto(unsortedLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}