package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 안된다면 예외가 발생한다.")
    @Test
    void createLottoByLowSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
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
    @DisplayName("로또 번호에 하나의 숫자라도 1 ~ 45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(47, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬 되어 있지 않다면 예외가 발생한다.")
    @Test
    void createLottoBySortedNumber() {
        List<Integer> numbers = List.of(7, 1, 3, 14, 5, 21);
        List<Integer> answer = List.of(1, 3, 5, 7, 14, 21);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.toString()).isEqualTo(answer.toString());
    }

}