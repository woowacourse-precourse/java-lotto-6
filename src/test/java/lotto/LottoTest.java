package lotto;

import model.Lotto;
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
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만, 45 초과의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByWrongRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 4, 44, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만, 45 초과의 숫자가 있으면 예외가 발생한다.2")
    @Test
    void createLottoByWrongRangeNumber2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 47, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬이 되는지 확인한다.")
    @Test
    void sortedLottoNumber() {
        // given
        List<Integer> numbers = List.of(6, 4, 5, 2, 1, 3);
        List<Integer> answerNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when
        Lotto lotto = new Lotto(numbers);
        // then
        assertThat(lotto.getNumbers().toString()).isEqualTo(answerNumbers.toString());
    }
}