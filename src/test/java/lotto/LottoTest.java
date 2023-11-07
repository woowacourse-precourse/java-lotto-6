package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
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

    @DisplayName("로또 번호가 정렬되어 생성되는지 확인한다.")
    @Test
    void createLottoByUnsortedNumber() {
        List<Integer> numbers = List.of(5, 4, 3, 2, 1, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호가 당첨 로또와 비교 하여 몇 개의 숫자가 맞았는지 확인한다.")
    @Test
    void getMatchCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getMatchCount(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lotto.getMatchCount(List.of(1, 2, 3, 4, 5, 7))).isEqualTo(5);
        assertThat(lotto.getMatchCount(List.of(1, 2, 3, 4, 7, 8))).isEqualTo(4);
        assertThat(lotto.getMatchCount(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
        assertThat(lotto.getMatchCount(List.of(1, 2, 7, 8, 9, 10))).isEqualTo(2);
        assertThat(lotto.getMatchCount(List.of(1, 7, 8, 9, 10, 11))).isEqualTo(1);
        assertThat(lotto.getMatchCount(List.of(7, 8, 9, 10, 11, 12))).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void hasBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.hasBonusNumber(bonusNumber)).isTrue();
    }
}