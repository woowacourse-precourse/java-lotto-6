package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유효한 경우 객체가 생성되어야 한다.")
    @Test
    void createValidLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("validate 메서드에서 6개의 로또 번호가 아닌 경우 예외가 발생해야 한다.")
    @Test
    void validateByInvalidSize() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5); // 6개의 번호가 아닌 경우
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validate 메서드에서 중복된 로또 번호가 있는 경우 예외가 발생해야 한다.")
    @Test
    void validateByDuplicatedNumber() {
        List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복된 번호가 있는 경우
        assertThatThrownBy(() -> new Lotto(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("validate 메서드에서 범위를 벗어난 로또 번호가 있는 경우 예외가 발생해야 한다.")
    @Test
    void validateByOutOfRangeNumber() {
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46); // 범위를 벗어난 번호가 있는 경우
        assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}