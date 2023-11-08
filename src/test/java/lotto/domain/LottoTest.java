package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호가 정렬이 되는지 확인한다.")
    @Test
    void sortedLottoNumber() {
        List<Integer> numbers = List.of(6, 4, 5, 2, 1, 3);
        List<Integer> answerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.toString()).isEqualTo(answerNumbers.toString());
    }

    @DisplayName("로또 번호가 정렬되어 저장된다.")
    @Test
    void ascendingSort() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호가 일치하는 개수를 반환한다.")
    @Test
    void matchCount() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(lotto1.matchCount(lotto2)).isEqualTo(3);
    }

    @DisplayName("로또 번호를 반환한다.")
    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호를 문자열로 반환한다.")
    @Test
    void toStringTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}