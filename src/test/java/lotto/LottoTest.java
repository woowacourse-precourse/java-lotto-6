package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import tool.Convert;
import validation.IntegerValidator;

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
    @DisplayName("로또 금액이 1,000 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputLottoPriceByIsNotRemainderZero() {
        assertThatThrownBy(() -> Input.inputLottoNumber("8400"))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("String을 Int List로 바꾸어 준 후 오름차순 정렬한다.")
    @Test
    void createIntListByInputString() {
        assertThat(Input.inputWinningNumbers("6,5,3,4,1,2")).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("1~45사이의 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByInputStringExceptRange1To45() {
        assertThatThrownBy(() -> new Lotto(Input.inputWinningNumbers("46,5,3,4,1,2")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기존 번호들과 중복된 값이 있으면 예외가 발생한다.")
    @Test
    void inputBonusNumberDuplicatedWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Input.inputBonusNumber("3", winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 발행될 때 중복되지 않은 숫자 6개가 선택되었는지 확인한다.")
    @Test
    void createLotto() {
        assertThatThrownBy(() ->
            assertThatThrownBy(() -> new Lotto())
            .isInstanceOf(IllegalArgumentException.class))
            .isInstanceOf(AssertionError.class);
    }
}
