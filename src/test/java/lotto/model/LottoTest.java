package lotto.model;

import lotto.exception.OutOfLottoNumberRangeException;
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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 0이 포함되면 예외가 발생한다.")
    @Test
    void createLottoByContainingZero() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("로또 번호에 음수가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByContainingMinus() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("로또 번호가 45를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByContainingOverRangeEnd() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .isInstanceOf(OutOfLottoNumberRangeException.class);
    }

    @DisplayName("정상적으로 입력된 경우 에러가 발생하지 않는다.")
    @Test
    void checkNoErrorWhenInputIsValid() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers())
                .containsExactlyElementsOf(List.of(1, 2, 3, 4, 5, 6));
    }
}