package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.message.LottoErrorMessage.INVALID_RANGE;
import static lotto.message.LottoErrorMessage.INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("로또 번호의 개수가 6개 보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_SIZE);
    }

    @DisplayName("로또 번호에 해당 주어진 번호를 포함한다.")
    @Test
    void compareNumberContainTrue() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int number = 4;
        assertThat(lotto.compareNumber(number)).isTrue();
    }

    @DisplayName("로또 번호에 해당 주어진 번호는 포함하지 않는다.")
    @Test
    void compareNumberContainFalse() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int number = 7;
        assertThat(lotto.compareNumber(number)).isFalse();
    }

    @DisplayName("로또 번호가 해당 리스트와 3개가 일치한다.")
    @Test
    void compareNumbersThreeCount() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> numbers = List.of(1,2,3,7,8,9);
        int expected = 3;
        assertThat(lotto.compareNumbers(numbers)).isEqualTo(expected);
    }

    @DisplayName("로또 번호 최대 수보다 크면 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE);
    }

    @DisplayName("로또 번호 최소 수보다 크면 예외가 발생한다.")
    @Test
    void createLottoByUnderNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE);
    }
}