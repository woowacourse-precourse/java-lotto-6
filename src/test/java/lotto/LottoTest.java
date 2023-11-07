package lotto;

import lotto.model.Lotto;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    @DisplayName("로또 번호에 범위에 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 범위에 벗어난 숫자가 있으면 예외가 발생한다2.")
    @Test
    void createLottoByOutOfRange2() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 타겟 숫자가 포함되어 있으면 True를 리턴한다.")
    @Test
    void containsTargetNumber() {
        int targetNumber = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.contains(targetNumber);

        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호에 타겟 숫자가 포함되어 있지 않으면 false를 리턴한다.")
    @Test
    void containsNotTargetNumber() {
        int targetNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.contains(targetNumber);

        assertThat(result).isFalse();
    }

    @DisplayName("로또 번호에 타겟 숫자가 포함되어 있지 않으면 false를 리턴한다.")
    @Test
    void getNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).isEqualTo(List.of(1,2,3,4,5,6));
    }
}